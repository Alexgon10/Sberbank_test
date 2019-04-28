package web_app.Database_controller;

public class QueryConstant {

    public static String SELECT_ALL="SELECT * FROM persons";

    public static String SELECT_ONE="SELECT * FROM persons WHERE id=?";

    public static  String INSERT= "INSERT INTO persons (firstname, middlename,lastname, age, gender)"
            +"  Values (?, ?, ?, ?, ?)";

    public static String UPDATE="UPDATE persons SET firstname = ?, middlename = ?,lastname = ?, age = ?  ,"
            +" gender = ? WHERE id = ?";

    public static String DELETE="DELETE FROM persons WHERE id = ?";


}
