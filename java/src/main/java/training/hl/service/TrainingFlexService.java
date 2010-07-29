package training.hl.service;

import java.util.Collection;

import training.hl.bean.Role;
import training.hl.bean.User;

public interface TrainingFlexService
{
	public Collection<User> getAllUsers();
	public Collection<Role> getAllRoles();
	public void saveUser(User user);
	public void saveRole(Role role);
}
