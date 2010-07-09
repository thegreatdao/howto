package training.hl.bean.ws;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

import training.hl.bean.Category;

@Data
@XmlRootElement
public class Categories implements Serializable
{
	private static final long serialVersionUID = -8399715483064290681L;
	
	private Collection<Category> categories;
	
	@XmlElement(name="category")
	public Collection<Category> getCategories()
	{
		return categories;
	}
}
