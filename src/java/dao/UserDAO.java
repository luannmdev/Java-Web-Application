/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Mission;
import model.Profile;
import model.Robot;
import model.Weapon;

/**
 *
 * @author LuanNMSE62431
 */
public class UserDAO {

    private static int SUCCESS = 1;

    public static Connection openConnection() {
        Connection conn = null;
        try {
            Class.forName(DBConfig.driver);
            conn = DriverManager.getConnection(DBConfig.url, DBConfig.user, DBConfig.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Profile getProfile(String username, String password) {
        Profile profile = null;
        String select = "Select username,fullname,phone,sex,birthday,role,picture,robot_id,status,free from tbl_users where username = ? and password = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(select)) {
            pStm.setString(1, username);
            pStm.setString(2, password);
            ResultSet rs = pStm.executeQuery();
            if (rs.next()) {
                profile = new Profile(rs.getString("username"), rs.getString("fullname"), rs.getString("phone"),
                        rs.getString("sex"), rs.getString("birthday"), "",
                        rs.getString("role"), rs.getString("picture"), rs.getString("robot_id"), rs.getBoolean("status"), rs.getBoolean("free"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile;
    }

    public static boolean addNewPillot(Profile profile) {
        String insert = "Insert into tbl_users Values(?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(insert)) {
            pStm.setString(1, profile.getUserName());
            pStm.setString(2, profile.getFullName());
            pStm.setString(3, profile.getPhone());
            pStm.setString(4, profile.getSex());
            pStm.setString(5, profile.getBirthday());
            pStm.setString(6, profile.getPassword());
            pStm.setString(7, profile.getRole());
            pStm.setString(8, profile.getPicture());
            pStm.setString(9, profile.getRobot_id());
            pStm.setBoolean(10, true);
            pStm.setBoolean(11, true);
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean addNewRobot(Robot robot) {
        String insert = "Insert into tbl_robots Values(?,?,?,?)";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(insert)) {
            pStm.setString(1, robot.getRobot_id());
            pStm.setString(2, robot.getRobot_name());
            pStm.setString(3, robot.getDescription());
            pStm.setBoolean(4, robot.isStatus());
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean addNewMission(Mission mission) {
        String insert = "Insert into tbl_missions Values(null,?,?,?,?)";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(insert)) {
            pStm.setString(1, mission.getMission_name());
            pStm.setString(2, mission.getDescription());
            pStm.setString(3, mission.getDate_start());
            pStm.setString(4, mission.getDate_end());
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static boolean addNewMissionMember(int missionId, String username) {
        String insert = "Insert into tbl_mission_members Values(?,?,?,?)";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(insert)) {
            pStm.setString(1, username);
            pStm.setInt(2, missionId);
            pStm.setString(3, "");
            pStm.setBoolean(4, true);
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean addNewWeapon(Weapon weapon) {
        String insert = "Insert into tbl_weapons Values(?,?,?,?,?)";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(insert)) {
            pStm.setString(1, weapon.getWeapon_id());
            pStm.setString(2, weapon.getWeapon_name());
            pStm.setString(3, weapon.getDescription());
            pStm.setString(4, weapon.getType());
            pStm.setString(5, weapon.getOwner());
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static Profile getProfileByAdmin(String username) {
        Profile profile = null;
        String select = "Select username,fullname,phone,sex,birthday,role,picture,robot_id,status,free from tbl_users where username = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(select)) {
            pStm.setString(1, username);
            ResultSet rs = pStm.executeQuery();
            if (rs.next()) {
                profile = new Profile(rs.getString("username"), rs.getString("fullname"), rs.getString("phone"),
                        rs.getString("sex"), rs.getString("birthday"), "",
                        rs.getString("role"), rs.getString("picture"), rs.getString("robot_id"), rs.getBoolean("status"), rs.getBoolean("free"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profile;
    }

    public static Profile checkLogin(String username, String password) {
        return getProfile(username, password);
    }

    public static boolean updateUser(Profile profile) {
        String update = "UPDATE tbl_users SET fullname = ?, phone = ? , sex = ? , birthday = ? WHERE username = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(update)) {
            pStm.setString(1, profile.getFullName());
            pStm.setString(2, profile.getPhone());
            pStm.setString(3, profile.getSex());
            pStm.setString(4, profile.getBirthday());
            pStm.setString(5, profile.getUserName());
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updatePassword(Profile profile) {
        String update = "UPDATE tbl_users SET password = ? WHERE username = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(update)) {
            pStm.setString(1, profile.getPassword());
            pStm.setString(2, profile.getUserName());
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean updateMissionDetail(int missionId,String mission_name,String description) {
        String update = "UPDATE tbl_missions SET mission_name = ? , description = ? WHERE mission_id = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(update)) {
            pStm.setString(1, mission_name);
            pStm.setString(2, description);
            pStm.setInt(3, missionId);
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Robot getRobotProfile(String robot_id) {
        Robot robot = null;
        String select = "Select robot_name,description,status from tbl_robots where robot_id = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(select)) {
            pStm.setString(1, robot_id);
            ResultSet rs = pStm.executeQuery();
            if (rs.next()) {
                robot = new Robot(robot_id, rs.getString("robot_name"), rs.getString("description"), rs.getBoolean("status"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return robot;
    }

    public static List<Weapon> getWeaponList(String robot_id) {
        List<Weapon> list = new ArrayList<>();
        String select = "select * from tbl_weapons where owner = ? ";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ps.setString(1, robot_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Weapon newWeapon = new Weapon(rs.getString("weapon_id"), rs.getString("weapon_name"), rs.getString("description"),
                        rs.getString("type"), rs.getString("owner"));
                list.add(newWeapon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Weapon> getAllWeapon() {
        List<Weapon> list = new ArrayList<>();
        String select = "select * from tbl_weapons";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Weapon newWeapon = new Weapon(rs.getString("weapon_id"), rs.getString("weapon_name"), rs.getString("description"),
                        rs.getString("type"), rs.getString("owner"));
                list.add(newWeapon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Mission getMissionDetailByMissionID(int mission_id) {
        Mission mission = null;
        String select = "Select * from tbl_missions where mission_id = ? ";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(select)) {
            pStm.setInt(1, mission_id);
            ResultSet rs = pStm.executeQuery();
            if (rs.next()) {
                mission = new Mission(rs.getInt("mission_id"), rs.getString("mission_name"), rs.getString("description"), rs.getString("date_start"), rs.getString("date_end"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mission;
    }

    public static List<Mission> getMissionListByUsername(String username) {
        List<Mission> list = new ArrayList<>();
        String select = "select * from tbl_mission_members where username = ?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int missionId = rs.getInt("mission_id");
                Mission mission = UserDAO.getMissionDetailByMissionID(missionId);
                list.add(mission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static List<Mission> getAllMissionList() {
        List<Mission> list = new ArrayList<>();
        String select = "Select * from tbl_missions";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mission mission = new Mission(rs.getInt("mission_id"), rs.getString("mission_name"), rs.getString("description"), rs.getString("date_start"), rs.getString("date_end"));
                list.add(mission);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static Weapon getMissionWeapon(String weaponId) {
        Weapon weapon = null;
        String select = "select * from tbl_weapons where weapon_id = ? ";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ps.setString(1, weaponId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                weapon = new Weapon(rs.getString("weapon_id"), rs.getString("weapon_name"), rs.getString("description"),
                        rs.getString("type"), rs.getString("owner"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weapon;
    }

    public static String getMissionWeaponID(String username, int missionId) {
        String weaponID = "";
        String select = "select weapon_id from tbl_mission_members where username = ? and mission_id = ? ";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ps.setString(1, username);
            ps.setInt(2, missionId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                weaponID = rs.getString("weapon_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weaponID;
    }

    public static String getNameByUsername(String username) {
        String name = null;
        String select = "Select fullname from tbl_users where username = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(select)) {
            pStm.setString(1, username);
            ResultSet rs = pStm.executeQuery();
            if (rs.next()) {
                name = rs.getString("fullname");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }

    public static List<String> getListOfMemberMission(int missionId) {
        List<String> list = new ArrayList<>();
        String select = "select username from tbl_mission_members where mission_id = ? ";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ps.setInt(1, missionId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = UserDAO.getNameByUsername(rs.getString("username"));
                list.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean updateWeaponMission(String username, int missionId, String weaponId) {
        String update = "UPDATE tbl_mission_members SET weapon_id = ? WHERE username = ? and mission_id = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(update)) {
            pStm.setString(1, weaponId);
            pStm.setString(2, username);
            pStm.setInt(3, missionId);
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Profile> getAllPillot() {
        List<Profile> list = new ArrayList<>();
        String select = "select username,fullname,phone,sex,birthday,role,picture,robot_id,status,free from tbl_users";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Profile profile = new Profile(rs.getString("username"), rs.getString("fullname"), rs.getString("phone"),
                        rs.getString("sex"), rs.getString("birthday"), "",
                        rs.getString("role"), rs.getString("picture"), rs.getString("robot_id"), rs.getBoolean("status"), rs.getBoolean("free"));
                list.add(profile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Robot> getAllRobot() {
        List<Robot> list = new ArrayList<>();
        String select = "select * from tbl_robots";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Robot robot = new Robot(rs.getString("robot_id"), rs.getString("robot_name"), rs.getString("description"), rs.getBoolean("status"));
                list.add(robot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Robot> getFreeRobotList() {
        List<Robot> list = new ArrayList<>();
        String select = "select * from tbl_robots where status = ?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ps.setBoolean(1, true);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Robot robot = new Robot(rs.getString("robot_id"), rs.getString("robot_name"), rs.getString("description"), rs.getBoolean("status"));
                list.add(robot);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean resetPassword(String userName) {
        String update = "UPDATE tbl_users SET password = ? WHERE username = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(update)) {
            pStm.setString(1, "123456");
            pStm.setString(2, userName);
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean blockPillot(String userName) {
        String update = "UPDATE tbl_users SET status = ? WHERE username = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(update)) {
            pStm.setBoolean(1, false);
            pStm.setString(2, userName);
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean unblockPillot(String userName) {
        String update = "UPDATE tbl_users SET status = ? WHERE username = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(update)) {
            pStm.setBoolean(1, true);
            pStm.setString(2, userName);
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateRobotForPilot(String username, String robotId) {
        String update = "UPDATE tbl_users SET robot_id = ? WHERE username = ? ";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(update)) {
            pStm.setString(1, robotId);
            pStm.setString(2, username);
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean updateRobotStatus(String robotId) {
        String update = "UPDATE tbl_robots SET status = ? WHERE robot_id = ? ";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(update)) {
            pStm.setBoolean(1, false);
            pStm.setString(2, robotId);
            int r = pStm.executeUpdate();
            pStm.close();
            if (r == SUCCESS) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Profile> searchPillotByName(String searchName) {
        List<Profile> list = new ArrayList<>();
        String select = "select username,fullname,phone,sex,birthday,role,picture,robot_id,status,free from tbl_users WHERE fullname like ?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ps.setString(1, "%" + searchName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Profile profile = new Profile(rs.getString("username"), rs.getString("fullname"), rs.getString("phone"),
                        rs.getString("sex"), rs.getString("birthday"), "",
                        rs.getString("role"), rs.getString("picture"), rs.getString("robot_id"), rs.getBoolean("status"), rs.getBoolean("free"));
                list.add(profile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<Weapon> getFreeWeaponList() {
        List<Weapon> list = new ArrayList<>();
        String select = "select * from tbl_weapons where owner = ?";
        try (Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(select)) {
            ps.setString(1, null);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Weapon weapon = weapon = new Weapon(rs.getString("weapon_id"), rs.getString("weapon_name"), rs.getString("description"),
                        rs.getString("type"), rs.getString("owner"));
                list.add(weapon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static void deleteWeapon(String weaponId) {
        String update = "DELETE from tbl_weapons WHERE weapon_id = ?";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(update)) {
            pStm.setString(1, weaponId);
            int r = pStm.executeUpdate();
            pStm.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int getMissionId() {
        int missionId =0;
        String select = "SELECT * FROM tbl_missions ORDER BY mission_id DESC LIMIT 1";
        try (Connection c = openConnection();
                PreparedStatement pStm = c.prepareStatement(select)) {
            ResultSet rs = pStm.executeQuery();
            if (rs.next()) {
                missionId = rs.getInt("mission_id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return missionId;
    }
}
