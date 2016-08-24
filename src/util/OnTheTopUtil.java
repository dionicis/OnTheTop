package util;

public final class OnTheTopUtil{
	private static OnTheTopUtil ott = new OnTheTopUtil();

	public static OnTheTopUtil getInstance(){
		return ott;
	}

	private static String[] tierArr = {"BRONZE", "SILVER", "GOLD", "PLATINUM","DIAMOND","MASTER"};
	private static String[] divArr = {"V", "IV", "III","II","I"};

	public int tierOrDivToNum(String tier, String[] arr){
		int tNum = 0;
		for(int i = 0; i<arr.length; i++)
			if(tier.equals(arr[i])){
				tNum = i;
				break;
			}
		return tNum;
	}
	public String[] getTierArr(){
		return tierArr;
	}

	public String[] getDivArr(){
		return divArr;
	}
}