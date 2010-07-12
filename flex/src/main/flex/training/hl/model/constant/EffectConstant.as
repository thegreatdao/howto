package training.hl.model.constant
{
	import spark.effects.easing.IEaser;
	import spark.effects.easing.Power;

	final public class EffectConstant
	{
		public static const DURATION:int = 400;
		public static const LONGER_DURATION:int = 1200;
		public static const EASE: IEaser = new Power( 0.30 );
	}
}