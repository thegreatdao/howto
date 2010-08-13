package training.hl.service;

import java.util.Collection;

import training.hl.bean.Role;
import training.hl.bean.User;

public interface TrainingFlexService
{
	public Collection<User> getAllUsers();
	public Collection<Role> getAllRoles();
	public User saveUser(User user);
	public void deleteUser(Long userId);
	public void deleteUserByUsername(String userName);
	public void saveRole(Role role);
}
