package training.hl.bean.ws;

import java.io.Serializable;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;
import training.hl.bean.Post;

import com.sun.xml.txw2.annotation.XmlElement;

@Data
@XmlRootElement
public class Posts implements Serializable
{
	private static final long serialVersionUID = 7161532775774942366L;
	
	private Collection<Post> posts;
	
	@XmlElement("post")
	public Collection<Post> getPosts()
	{
		return posts;
	}
}
