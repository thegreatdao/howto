package training.hl.bean.ws;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import training.hl.bean.Post;

@Data
@XmlRootElement
public class Posts implements Serializable
{
	private static final long serialVersionUID = 7161532775774942366L;
	
	private Collection<Post> posts;
	
	@XmlElement(name="post")
	public Collection<Post> getPosts()
	{
		return posts;
	}
}
