package training.hl.bean.pagination;

import java.io.Serializable;
import java.util.Collection;

import lombok.Data;

@Data
public class Pagination<T> implements Serializable
{
	private static final long serialVersionUID = 4337288334672181983L;

	private long totalNumOfRecords;
	private int currentIndex;
	private int numOfRecordsPerPage;
	private Collection<T> records;
}
