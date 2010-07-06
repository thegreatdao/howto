package training.hl.exception;

public class TrainingRootException extends RuntimeException
{
	private static final long serialVersionUID = 4299377742887352067L;

	public TrainingRootException()
	{
		
	}

	public TrainingRootException(String message)
	{
		super(message);
	}

	public TrainingRootException(Throwable cause)
	{
		super(cause);
	}

	public TrainingRootException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
