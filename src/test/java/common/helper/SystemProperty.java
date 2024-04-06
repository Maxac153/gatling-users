package common.helper;

public class SystemProperty {
    public final static String FILE_NAME_READ = System.getProperty("FILE_NAME_READ", "users_data.csv");
    public final static String FILE_NAME_ADD = System.getProperty("FILE_NAME_ADD", "users_data_used.csv");
}
