/**
 * 
 */
package Repository;

import Model.AddressModel;
import Model.StudentModel;

/**
 * @author sruthi danda
 *
 */
public interface AddressInterface {
	public void insert(AddressModel addressModel);
	public AddressModel getAddressID();
	public AddressModel getCurrentAddressID(StudentModel studentModel);
	public void update(AddressModel addressModel);
}
