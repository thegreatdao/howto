package training.hl.aop.logging;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrainingLogAspect
{
	private final Logger LOGGER = LoggerFactory.getLogger(TrainingLogAspect.class);
	
	/*@Around("execution(* training.hl.web.ws.*.*(..))")
	public void logWsResources(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
	{
		Signature signature = proceedingJoinPoint.getSignature();
		LOGGER.info(signature + " invoked at --" + new Date());
		proceedingJoinPoint.proceed();
		LOGGER.info(signature + " ended at --" + new Date());
	}*/
	
	@Before("execution(* training.hl.web.controller.*.*(..))")
	public void logControllers(JoinPoint joinPoint) throws Throwable
	{
		Signature signature = joinPoint.getSignature();
		LOGGER.info(signature + " invoked at --" + new Date());
	}
	
	@Before("execution(@org.springframework.transaction.annotation.Transactional * *(..))")
	public void logB4Daos(JoinPoint joinPoint) throws Throwable
	{
		Signature signature = joinPoint.getSignature();
		LOGGER.info(signature + " ended at --" + new Date());
	}
	
	@After("execution(@org.springframework.transaction.annotation.Transactional * *(..))")
	public void logAfterDaos(JoinPoint joinPoint) throws Throwable
	{
		Signature signature = joinPoint.getSignature();
		LOGGER.info(signature + " ended at --" + new Date());
	}
	
	@Pointcut("execution(@training.hl.aop.logging.annotation.Form * *(..))")
	public void logControllerUserForm()
	{
	}
	
	@Before("logControllerUserForm()")
	public void logControllerUserForm(JoinPoint joinPoint) throws Throwable
	{
		Signature signature = joinPoint.getSignature();
		LOGGER.info(signature + " invoked at --" + new Date());
	}
	
	@Pointcut("execution(* training.hl.web.controller.*.save(..))")
	public void logControllerSave()
	{
	}
	
	@Before("logControllerSave()")
	public void logControllerB4Save(JoinPoint joinPoint) throws Throwable
	{
		Signature signature = joinPoint.getSignature();
		LOGGER.info(signature + " invoked at --" + new Date());
	}
	
	@After("logControllerSave()")
	public void logControllerAfterSave(JoinPoint joinPoint) throws Throwable
	{
		Signature signature = joinPoint.getSignature();
		LOGGER.info(signature + " ended at --" + new Date());
	}
}
