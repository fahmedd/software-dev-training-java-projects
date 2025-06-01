package com.fdmgroupStaticKeyword;

public class EnergyMatterCalculator {
	
	public static double SPEED_OF_LIGHT= 299792458;
	
	public static double matterToEnergy (double matter) {
		return (matter*(SPEED_OF_LIGHT*SPEED_OF_LIGHT));
	}
	
	
	public static double energyToMatter (double energy) {
		return (energy/(SPEED_OF_LIGHT*SPEED_OF_LIGHT));
	}

	//// other way
	
//	public class EnergyMatterCalculator {
//		public static double SPEED_OF_LIGHT = 299792458;
//		
//		public static double matterToEnergy(double matter) {
//			return (matter * Math.pow(SPEED_OF_LIGHT, 2));
//		}
//		
//		public static double energyToMatter(double energy) {
//			return (energy / Math.pow(SPEED_OF_LIGHT, 2));
//		}
//	}

	
}
