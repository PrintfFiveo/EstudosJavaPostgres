public class UserLogin {
    DatabaseFunc db = new DatabaseFunc();
    public void getUser(String email, String password){
        db.select_query("users", email, password);


    }


}
