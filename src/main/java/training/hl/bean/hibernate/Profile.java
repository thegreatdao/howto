package training.hl.bean.hibernate;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Profile
{
	private String bio;
	private String hobbies;
	private String homePage;
}