package com.progex.zoomanagementsoftware.ManagersAndHandlers;

import com.progex.zoomanagementsoftware.datatypes.*;
import com.progex.zoomanagementsoftware.hashing.MD5Hash;
import java.util.LinkedList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * @(#) UserManager.java
 */
public class UserManager {

    private User loggedInUser;

    private ConnectionHandler connectionHandler;

    private ZooManager zooManager; //Knows the reference to its owner, probably todo: rethink structcure

    /*Removed loggedInUser TODO DIAGRAM*/
    public UserManager(ConnectionHandler connectionHandler, ZooManager zooManager) {
        this.loggedInUser = null;
        this.connectionHandler = connectionHandler;
        this.zooManager = zooManager;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public ConnectionHandler getConnectionHandler() {
        return connectionHandler;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    //TODO Überlegen ob es Sinn macht addressen auch hier zu verwalten,wäre
    //praktisch machbar...
    /**
     * Method which access the users which are stored in the database
     *
     * @return A LinkedList of User objects
     */
    public LinkedList<User> getUsers() {

        String query = "SELECT User.ID,Type,Shift,Salutation,UserName,FirstName,LastName,\n"
                + "PhoneNumber,Birthday,Email,Zip,Street,City,\n"
                + "Country,LastLogDate,HashedPassword\n"
                + "FROM User\n"
                + "INNER JOIN Address ON User.AddressID = Address.ID";

        ResultSet resultSet = connectionHandler.performQuery(query);
        LinkedList<User> users = createUsers(resultSet);

        return users;
    }

    /**
     * Method which has been implemented to create a user datastructure from a
     * resultSet which has all requiered attributes.
     *
     * @param resultSet
     * @return A LinkedList which contains all users depending on the result set
     */
    private LinkedList<User> createUsers(ResultSet resultSet) {

        LinkedList<User> users = new LinkedList<User>();
        Methods methods = new Methods();

        try {

            while (resultSet.next()) {

                int id = resultSet.getInt("ID");
                String type = resultSet.getString("Type");
                String shiftStr = resultSet.getString("Shift");
                String salutationStr = resultSet.getString("Salutation");
                String username = resultSet.getString("UserName");
                String firstname = resultSet.getString("FirstName");
                String lastname = resultSet.getString("LastName");
                String phoneNumber = resultSet.getString("PhoneNumber");
                Date birthday = resultSet.getDate("Birthday");
                String email = resultSet.getString("Email");
                String zip = resultSet.getString("Zip");
                String street = resultSet.getString("Street");
                String city = resultSet.getString("City");
                String country = resultSet.getString("Country");
                Timestamp lastLogDate = resultSet.getTimestamp("LastLogDate");
                String hashedPassword = resultSet.getString("hashedPassword");

                Address address = new Address(id, street, country, zip, city);
                Salutation salutation = methods.stringToSalutation(salutationStr);
                Shift shift = methods.stringToShift(shiftStr);

                //Creating a user depending of the type
                switch (type) {

                    case "Admin":
                        Admin admin = new Admin(username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
                        users.add(admin);
                        break;
                    case "Zookeeper":

                        Zookeeper zookeeper = new Zookeeper(shift, username, firstname, lastname, email, phoneNumber, id, salutation, birthday, hashedPassword, address, lastLogDate);
                        users.add(zookeeper);

                        break;
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL exception");
            System.out.println(e.getMessage());

        }
        return users;
    }

    //TODO MAKE SMALLER METHOD (one which takes a user as parameter for example)!!!
    /**
     * Method to add an user in the database.
     *
     * @param shift
     * @param user
     * @param userType
     * @return true if operation was successful, else false
     */
    public boolean addUser(User user, String shift, String userType) {
        //Get the address with street,zip,city --> I guess country not requird
        int addressId = searchAddressId(user.getAddress().getZip(), user.getAddress().getStreet(), user.getAddress().getCity());

        boolean retVal;

        MD5Hash hasher = new MD5Hash();

        String hashedPassword = hasher.hashString(user.getHashedPassword());
        if (addressId == -1) {
            retVal = addAddress(user.getAddress().getZip(), user.getAddress().getCity(), user.getAddress().getCountry(), user.getAddress().getStreet());
            //Falls die Adresse nicht eingefügt werden konnte
            if (retVal == false) {
                return retVal;
            }
        }
        Methods methods = new Methods();
        String salutation = methods.salutationToString(user.getSalutation());
        //Know the user can be added 
        String insertUserQuery = "INSERT INTO User (UserName,FirstName,LastName,PhoneNumber,"
                + "Birthday,Email,Salutation,HashedPassword,"
                + "AddressID,Type,Shift,LastLogDate)\n"
                + "VALUES ('" + user.getUsername() + "',"
                + "'" + user.getFirstname() + "',"
                + "'" + user.getLastname() + "',"
                + "'" + user.getPhoneNumber() + "',"
                + "'" + user.getBirthday().toString() + "',"
                + "'" + user.getEmail() + "',"
                + "'" + salutation + "',"
                + "'" + hashedPassword + "',"
                + addressId + ","
                + "'" + userType + "',"
                + "'" + shift + "',"
                + "'1998-01-01 00:00:00')"; //Using zeros as initial log date -> does not work

        retVal = connectionHandler.manipulateDB(insertUserQuery);
        return retVal;
    }

    /**
     * Method to add an address in the database.
     *
     * @param zip
     * @param city
     * @param country
     * @param street
     * @return true if operation was successful, else false
     */
    public boolean addAddress(String zip, String city, String country, String street) {

        String insertAddressQuery = "INSERT INTO Address (Zip, Street, Country, City)"
                + "VALUES ('" + zip + "','" + street + "','" + country + "','" + city + "')";
        System.out.println(insertAddressQuery);
        boolean retVal = connectionHandler.manipulateDB(insertAddressQuery);
        return retVal;
    }

    /**
     * Method which has been implemented to search an addressId depending on the
     * given parameters.
     *
     * @param zip
     * @param street
     * @param city
     * @return the addressId if its found, else -1
     */
    public int searchAddressId(String zip, String street, String city) {

        int addressId = -1; //-1 as initial error value

        String addressQuery = "SELECT ID FROM Address "
                + "WHERE Zip = '" + zip + "'"
                + " AND Street = '" + street + "'"
                + " AND City = '" + city + "'";

        ResultSet addressResultSet = connectionHandler.performQuery(addressQuery);
        if (addressResultSet == null) {
            return addressId; //Message ? 
        }
        try {
            addressResultSet.next();
            addressId = addressResultSet.getInt("ID");
        } catch (SQLException ex) {
            System.err.println("SQL Exception");
            System.out.println(ex.getMessage());
            return -1;
        }
        return addressId;
    }

    //TODO COUNTRY WIRD GAR NICHT GEBRAUCHT ???
    /**
     * Method to update an user in the database.
     *
     * @param id
     * @param type
     * @param salutation
     * @param firstname
     * @param lastname
     * @param street
     * @param zip
     * @param city
     * @param country
     * @param phoneNumber
     * @param birthday
     * @param shift
     * @param username
     * @param email
     * @param password
     * @param changePassword
     * @return true if operation is sucessful, else false
     */
    public boolean updateUser(int id, User user, String shift, String userType, boolean changePassword) {

        MD5Hash hasher = new MD5Hash();
        String hashedPassword = hasher.hashString(user.getHashedPassword());

        int addressId = searchAddressId(user.getAddress().getZip(), user.getAddress().getStreet(), user.getAddress().getCity());
        //Check if username changed and if yes, check if new username already used     
        String oldUsername = " ";
        String userNameQuery = "SELECT UserName FROM USER WHERE ID = " + id;
        ResultSet resultSet = connectionHandler.performQuery(userNameQuery);
        boolean retVal;

        if (resultSet != null) {

            try {
                if (resultSet.next()) {
                    oldUsername = resultSet.getString("UserName");
                }

            } catch (SQLException ex) {
                System.err.println("SQL Exception");
                System.out.println(ex.getMessage());
            }
        }

        if (!oldUsername.equals(user.getUsername())) {
            if (this.usernameExists(user.getUsername())) {
                return false;
            }
        }

        if (addressId == -1) {
            retVal = addAddress(user.getAddress().getZip(), user.getAddress().getCity(), user.getAddress().getCountry(), user.getAddress().getStreet());
            addressId = searchAddressId(user.getAddress().getZip(), user.getAddress().getStreet(), user.getAddress().getCity());
            if (retVal == false) {
                return retVal;
            }
        }

        Methods methods = new Methods();
        String salutation = methods.salutationToString(user.getSalutation());

        String query = "UPDATE User\n"
                + "SET UserName = '" + user.getUsername() + "',\n"
                + "FirstName = '" + user.getFirstname() + "',\n"
                + "LastName = '" + user.getLastname() + "',\n"
                + "PhoneNumber = '" + user.getLastname() + "',\n"
                + "Birthday = '" + user.getBirthday().toString() + "',\n"
                + "Email = '" + user.getEmail() + "',\n"
                + "Salutation = '" + salutation + "',\n"
                //+ "HashedPassword = '" + hashedPassword + "',\n"
                + "AddressID = " + addressId + ",\n";

        if (userType.equals("Admin")) {
            query = query
                    + "Type = 'Admin',\n"
                    + "Shift = 'None'\n";
        } else {

            query = query
                    + "Type = 'Zookeeper',\n"
                    + "Shift = '" + shift + "',\n";
        }

        if (changePassword) {

            query = query + " ,HashedPassword = '" + hashedPassword + "'\n"
                    + " WHERE ID = " + id;
        } else {
            query = query + " WHERE ID = " + id;
        }

        System.out.println(query);
        return connectionHandler.manipulateDB(query);
    }

    /**
     * Method which deletes a user from the database.
     *
     * @param id
     * @return true if operation is successful, else false
     */
    public boolean deleteUser(int id) {

        String query = "DELETE FROM User WHERE ID = " + id;
        boolean retVal = connectionHandler.manipulateDB(query);
        return retVal;
    }

    /**
     * Method to search for users in the database with limit, ordered by the
     * last log date
     *
     * @param columnValueMap A mapping of entity attributes and corresponding
     * @param limit An amount of users we want to have
     * @return A LinkedList which contains the searched users
     */
    public LinkedList<User> searchUsers(LinkedHashMap<String, String> columnValueMap, String limit) {

        String begin = "SELECT User.ID,Type,Shift,Salutation,UserName,FirstName,LastName,\n"
                + "PhoneNumber,Birthday,Email,Zip,Street,City,\n"
                + "Country,LastLogDate,HashedPassword\n"
                + "FROM User\n"
                + "INNER JOIN Address ON User.AddressID = Address.ID WHERE ";
        String query = zooManager.generateSearchQuery(columnValueMap, begin);

        query = query + " ORDER BY LastLogDate DESC LIMIT " + limit;
        System.out.println(query);

        LinkedList<User> users = null;
        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            users = createUsers(resultSet);
        } else {
            return this.getUsers(); //Case if we have no attributes
        }
        return users;
    }

    /**
     * Method to search for users in the database.
     *
     * @param columnValueMap A mapping of entity attributes and corresponding
     * values
     * @return A LinkedList which contains the searched users
     */
    public LinkedList<User> searchUsers(LinkedHashMap<String, String> columnValueMap) {

        String begin = "SELECT User.ID,Type,Shift,Salutation,UserName,FirstName,LastName,\n"
                + "PhoneNumber,Birthday,Email,Zip,Street,City,\n"
                + "Country,LastLogDate,HashedPassword\n"
                + "FROM User\n"
                + "INNER JOIN Address ON User.AddressID = Address.ID WHERE ";
        String query = zooManager.generateSearchQuery(columnValueMap, begin);

        System.out.println(query);

        LinkedList<User> users = null;
        if (query != null) {
            ResultSet resultSet = connectionHandler.performQuery(query);
            users = createUsers(resultSet);
        } else {
            return this.getUsers(); //Case if we have no attributes
        }
        return users;
    }

    /**
     * Method to check if a username already exists in the database.
     *
     * @param username
     * @return true if it exists, else false
     */
    public boolean usernameExists(String username) {

        boolean retVal = false;

        String query = "SELECT UserName FROM User WHERE UserName = '" + username + "'";
        ResultSet resultSet = connectionHandler.performQuery(query);
        try {

            if (resultSet.next()) {
                retVal = true;
            }

        } catch (SQLException ex) {
            System.err.println("SQL Exception");
            System.out.println(ex.getMessage());
        }

        return retVal;
    }

    //Khalid start 
    //
    /**
     * Method returns a user after checking if the given username and hashed
     * password match.
     *
     * @param username
     * @param hashedPassword
     * @return User that has been successfully logged in, else null
     */
    public User login(String username, String hashedPassword) {

        try {
            // set query
            String query = "SELECT username, firstname, user.Type, lastlogdate FROM USER WHERE username = \"" + username + "\"";
            // perform query
            ResultSet resultSet = connectionHandler.performQuery(query);

            // set variable to catch result from query
            String firstName = "";
            String userName = "";
            Timestamp lastLogDate = null;
            String type = "";

            // catch results from query and save in variables
            if (resultSet.next()) {

                userName = resultSet.getString(1);
                firstName = resultSet.getString(2);
                type = resultSet.getString(3);
                lastLogDate = resultSet.getTimestamp(4);

                if (type.equals("Admin")) {
                    Admin admin = new Admin(userName, firstName, lastLogDate);
                    return admin;
                }
                if (type.equals("Zookeeper")) {
                    Zookeeper zookeeper = new Zookeeper(userName, firstName, lastLogDate);
                    return zookeeper;
                } else {
                    return null;
                }

            }
        } catch (SQLException ex) {
            System.err.println("SQL EXCEPTION");
            System.out.println(ex.getMessage());
        }

        return null;

    }

    /**
     * Updates the lastlogdate from the logged in user
     *
     *
     */
    public void updateLastLogDateFromUser() {

        // set query        
        String query = "UPDATE user "
                + "SET LastLogDate = current_timestamp() WHERE username = \"" + loggedInUser.getUsername() + "\"";

        // perform query
        connectionHandler.manipulateDB(query);

    }

    /**
     * Logsout the user and resets the user, also updates the lastlogdate when
     * logging out
     *
     *
     */
    public void logout() {

        updateLastLogDateFromUser();
        loggedInUser = null;
    }

    /**
     * TODO RETURN COMMENT WAS FALLS ES WELCHE GIBT DIE ZU GLEICHEN ZEIT HABEN
     * Get NextFeedingInfo Object to display a zookeepers next feeding time.
     *
     * @return ZookeeperInfo that shows all important information for the next
     * feeding info for the zookeeper.
     *
     */
    public ZookeeperInfo getNextFeedingInfo() {

        try {
            // set query
            String query
                    = "SELECT case when diffMin<0 then 'Abgelaufen' else diffMin end as InMinuten,Tier,Futter,MengeGR as MengeinGramm,Abstellraumnummer,Gehege  "
                    + "FROM "
                    + "(SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount * 1000 AS MengeGR, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName,TIMEDIFF(CONVERT(eats.StartFeedingTime, time), current_time()) as diffMin, CONVERT(eats.StartFeedingTime, time) as Uhrzeit "
                    + "FROM eats "
                    + "INNER JOIN food ON eats.FoodID = food.ID "
                    + "INNER JOIN animal ON eats.AnimalID = animal.ID "
                    + "INNER JOIN takescare ON eats.AnimalID = takescare.AnimalID "
                    + "INNER JOIN user ON takescare.UserID = user.ID "
                    + "INNER JOIN compound ON animal.CompoundID = compound.ID) AS joinedTable "
                    + "WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" and joinedTable.FütterungsZeit > current_date() "
                    + "ORDER BY case when diffMin<0 then 1 else 0 end,diffMin "
                    + "LIMIT 2";

            ResultSet resultSet = connectionHandler.performQuery(query);

            // init variables to catch from resultset
            ArrayList<ZookeeperInfo> zookeeperInfolist = new ArrayList<>();
            String tiername = "";
            String futter = "";
            double menge = 0;
            String abstellRaum = "";
            String gehege = "";
            Timestamp feedingTimeInMinutes = null;
            ZookeeperInfo zookeeperInfo = null;

            // set variables from resultset
            if (resultSet.next()) {
                tiername = resultSet.getString(2);
                futter = resultSet.getString(3);
                menge = Double.parseDouble(resultSet.getString(4));
                abstellRaum = resultSet.getString(5);
                gehege = resultSet.getString(6);
                feedingTimeInMinutes = resultSet.getTimestamp(1);
                zookeeperInfo = new ZookeeperInfo(feedingTimeInMinutes, gehege, tiername, futter, abstellRaum, menge);
                zookeeperInfolist.add(zookeeperInfo);

            }

            for (int i = 0; i < zookeeperInfolist.size(); i++) {
                System.out.println("TIME:" + zookeeperInfolist.get(i).getFeedingTime());
            }

            if (checkIfSameTime(resultSet)) {
                zookeeperInfo.setIsMultipleFeeding(true);
            } else {
                zookeeperInfo.setIsMultipleFeeding(false);
            }

            System.out.println("COUNT" + checkIfSameTime(resultSet));

            // create FeedingInfo based on Database Information and return it
            return zookeeperInfo;
        } catch (SQLException ex) {
            System.err.println("SQL EXCEPTION");
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public boolean checkIfSameTime(ResultSet rs1) {

        try {
            String time1 = rs1.getString("InMinuten");
            rs1.last();
            String time2 = rs1.getString("InMinuten");

            System.out.println("TIME1" + time1);
            System.out.println("TIME2" + time2);

            if (time1.equals(time2)) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * This Methods returns a resultset of all Feeding Informations for a user
     * -> amount is in Kilogramm, resultset is later used to populate the jtable
     *
     * @return ResultSet witth allfeedingtimes to populate the resultset in
     * another method
     */
    public ResultSet getAllFeedingTimeInKG() {

        String query
                = "SELECT Uhrzeit, case when diffMin<0 then 'Abgelaufen' else diffMin end as \"Findet statt in HH:MM:SS\", Tier,Futter,MengeKG as \"Menge in Kilogramm\",Abstellraumnummer,Gehege "
                + "FROM "
                + "(SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount AS MengeKG, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName,TIMEDIFF(CONVERT(eats.StartFeedingTime, time), current_time()) as diffMin, CONVERT(eats.StartFeedingTime, time) as Uhrzeit "
                + "FROM eats "
                + "INNER JOIN food ON eats.FoodID = food.ID "
                + "INNER JOIN animal ON eats.AnimalID = animal.ID "
                + "INNER  JOIN takescare ON eats.AnimalID = takescare.AnimalID "
                + "INNER JOIN user ON takescare.UserID = user.ID "
                + "INNER JOIN compound ON animal.CompoundID = compound.ID) AS joinedTable "
                + "WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" and joinedTable.FütterungsZeit > current_date() "
                + "ORDER BY case when diffMin<0 then 1 else 0 end,diffMin";

        return connectionHandler.performQuery(query);

    }

    /**
     * This Methods returns a resultset of all Feeding Informations for a user
     * -> amount is in Gramm resultset is later used to populate the jtable.
     *
     * @return ResultSet witth allfeedingtimes to populate the resultset in
     * another method.
     */
    public ResultSet getAllFeedingTimeInGramm() {

        String query
                = "SELECT Uhrzeit,case when diffMin<0 then 'Abgelaufen' else diffMin end as \"Findet statt in HH:MM:SS\",Tier,Futter,MengeGR as \"Menge in Gramm\",Abstellraumnummer,Gehege "
                + "FROM "
                + "(SELECT eats.StartFeedingTime AS Fütterungszeit, animal.AnimalName AS Tier ,food.Name AS Futter, eats.Amount * 1000 AS MengeGR, food.StorageRoomNumber AS Abstellraumnummer, compound.Name AS Gehege, user.UserName,TIMEDIFF(CONVERT(eats.StartFeedingTime, time), current_time()) as diffMin, CONVERT(eats.StartFeedingTime, time) as Uhrzeit "
                + "FROM eats "
                + "INNER JOIN food ON eats.FoodID = food.ID "
                + "INNER JOIN animal ON eats.AnimalID = animal.ID "
                + "INNER  JOIN takescare ON eats.AnimalID = takescare.AnimalID "
                + "INNER JOIN user ON takescare.UserID = user.ID "
                + "INNER JOIN compound ON animal.CompoundID = compound.ID) AS joinedTable "
                + "WHERE joinedTable.UserName = \"" + loggedInUser.getUsername() + "\" and joinedTable.FütterungsZeit > current_date() "
                + "ORDER BY case when diffMin<0 then 1 else 0 end,diffMin";

        return connectionHandler.performQuery(query);

    }

    /**
     * Return minutes until next feeding time for zookeeper.
     *
     * @return the next feeding time in minutes
     */
    public String getNextFeedingInfoInProperFormat() {

        Methods methods = new Methods();

        String unformattedTime = getNextFeedingInfo().getFeedingTime().toString();

        String formattedTime = methods.cutTimeNextFeeding(unformattedTime);

        return formattedTime;

    }

    //Khalid end
}
