package Repository;

import java.sql.ResultSet;

import Model.AuthenticationModel;
/**
 * @author sruthi danda
 *
 */
public interface AuthenticationInterface {
	public AuthenticationModel getUsers(String id);
	public ResultSet getAllUsers();
	public void insert(AuthenticationModel authenticationModel);
	public void resetPassword(AuthenticationModel authenticationModel);
}
