package semi.jh.food.model.dto;

public class ProcessecFoodDto {
//	FOOD_CODE          NOT NULL VARCHAR2(10)  
//	FOOD_NAME          NOT NULL VARCHAR2(100) 
//	MANUFACTURER       NOT NULL VARCHAR2(100) 
//	SERVING_SIZE       NOT NULL NUMBER        
//	CONTENT_UNIT       NOT NULL VARCHAR2(2)   
//	GRAM               NOT NULL NUMBER        
//	MILLILITER         NOT NULL NUMBER        
//	CALORIES           NOT NULL NUMBER        
//	TOTAL_CARBOHYDRATE          NUMBER        
//	PROTEIN                     NUMBER        
//	TOTAL_FAT                   NUMBER        
//	SUGARS                      NUMBER        
//	SODUIM                      NUMBER        
//	CHOLESTEROL                 NUMBER        
//	SATURATED_FAT               NUMBER        
//	TRANS_FAT          NOT NULL NUMBER        
//	INFORMATION_SOURCE NOT NULL VARCHAR2(100) 
//	LSSUER             NOT NULL VARCHAR2(100) 
	
	private String foodCode;
	private String foodName;
	private String manufacturer;
	private Integer foodDate;
	private Integer servingSize;
	private String unit;
	private Integer gram;
	private Integer milliter;
	private Integer calories;
	private Integer totalCarbohydrate;
	private Integer protein;
	private Integer totalFat;
	private Integer sugars;
	private Integer soduim;
	private Integer cholesterol;
	private Integer saturatedFat;
	private Integer transFat;
	private String imformationSource;
	private String lassuer;
	private String foodDbCategory;
	private String foodCategory;
	
	
	
	@Override
	public String toString() {
		return "ProcessecFoodDto [foodCode=" + foodCode + ", foodName=" + foodName + ", manufacturer=" + manufacturer
				+ ", foodDate=" + foodDate + ", servingSize=" + servingSize + ", unit=" + unit + ", gram=" + gram
				+ ", milliter=" + milliter + ", calories=" + calories + ", totalCarbohydrate=" + totalCarbohydrate
				+ ", protein=" + protein + ", totalFat=" + totalFat + ", sugars=" + sugars + ", soduim=" + soduim
				+ ", cholesterol=" + cholesterol + ", saturatedFat=" + saturatedFat + ", transFat=" + transFat
				+ ", imformationSource=" + imformationSource + ", lassuer=" + lassuer + ", foodDbCategory="
				+ foodDbCategory + ", foodCategory=" + foodCategory + "]";
	}

	public ProcessecFoodDto() {
	}
	
	public ProcessecFoodDto(String foodName, String manufacturer, Integer calories) {
		super();
		this.foodName = foodName;
		this.manufacturer = manufacturer;
		this.calories = calories;
	}
	
	
	


	public ProcessecFoodDto(String foodName, String manufacturer, Integer foodDate, String foodDbCategory, String foodCategory,
			String imformationSource, Integer calories) {
		super();
		this.foodName = foodName;
		this.manufacturer = manufacturer;
		this.foodDate = foodDate;
		this.foodDbCategory = foodDbCategory;
		this.foodCategory = foodCategory;
		this.imformationSource = imformationSource;
		this.calories = calories;
	}

//	rs.getString("food_name"), 
//	rs.getString("manufacturer"),
//	rs.getInt("food_date"),
//	rs.getString("food_db_category"),
//	rs.getString("food_category"),
//	rs.getString("information_source"),
//	rs.getInt("calories"));


	


	public ProcessecFoodDto(String foodCode, String foodName, String manufacturer, Integer foodDate,
			Integer servingSize, String unit, Integer gram, Integer milliter, Integer calories,
			Integer totalCarbohydrate, Integer protein, Integer totalFat, Integer sugars, Integer soduim,
			Integer cholesterol, Integer saturatedFat, Integer transFat, String imformationSource, String lassuer,
			String foodDbCategory, String foodCategory) {
		super();
		this.foodCode = foodCode;
		this.foodName = foodName;
		this.manufacturer = manufacturer;
		this.foodDate = foodDate;
		this.servingSize = servingSize;
		this.unit = unit;
		this.gram = gram;
		this.milliter = milliter;
		this.calories = calories;
		this.totalCarbohydrate = totalCarbohydrate;
		this.protein = protein;
		this.totalFat = totalFat;
		this.sugars = sugars;
		this.soduim = soduim;
		this.cholesterol = cholesterol;
		this.saturatedFat = saturatedFat;
		this.transFat = transFat;
		this.imformationSource = imformationSource;
		this.lassuer = lassuer;
		this.foodDbCategory = foodDbCategory;
		this.foodCategory = foodCategory;
	}
	public Integer getFoodDate() {
		return foodDate;
	}
	
	
	
	public void setFoodDate(Integer foodDate) {
		this.foodDate = foodDate;
	}
	
	
	
	public String getFoodDbCategory() {
		return foodDbCategory;
	}
	
	
	
	public void setFoodDbCategory(String foodDbCategory) {
		this.foodDbCategory = foodDbCategory;
	}
	
	
	
	public String getFoodCategory() {
		return foodCategory;
	}
	
	
	
	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}
	
	public String getFoodCode() {
		return foodCode;
	}
	public void setFoodCode(String foodCode) {
		this.foodCode = foodCode;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Integer getServingSize() {
		return servingSize;
	}
	public void setServingSize(Integer servingSize) {
		this.servingSize = servingSize;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getGram() {
		return gram;
	}
	public void setGram(Integer gram) {
		this.gram = gram;
	}
	public Integer getMilliter() {
		return milliter;
	}
	public void setMilliter(Integer milliter) {
		this.milliter = milliter;
	}
	public Integer getCalories() {
		return calories;
	}
	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	public Integer getTotalCarbohydrate() {
		return totalCarbohydrate;
	}
	public void setTotalCarbohydrate(Integer totalCarbohydrate) {
		this.totalCarbohydrate = totalCarbohydrate;
	}
	public Integer getProtein() {
		return protein;
	}
	public void setProtein(Integer protein) {
		this.protein = protein;
	}
	public Integer getTotalFat() {
		return totalFat;
	}
	public void setTotalFat(Integer totalFat) {
		this.totalFat = totalFat;
	}
	public Integer getSugars() {
		return sugars;
	}
	public void setSugars(Integer sugars) {
		this.sugars = sugars;
	}
	public Integer getSoduim() {
		return soduim;
	}
	public void setSoduim(Integer soduim) {
		this.soduim = soduim;
	}
	public Integer getCholesterol() {
		return cholesterol;
	}
	public void setCholesterol(Integer cholesterol) {
		this.cholesterol = cholesterol;
	}
	public Integer getSaturatedFat() {
		return saturatedFat;
	}
	public void setSaturatedFat(Integer saturatedFat) {
		this.saturatedFat = saturatedFat;
	}
	public Integer getTransFat() {
		return transFat;
	}
	public void setTransFat(Integer transFat) {
		this.transFat = transFat;
	}
	public String getImformationSource() {
		return imformationSource;
	}
	public void setImformationSource(String imformationSource) {
		this.imformationSource = imformationSource;
	}
	public String getLassuer() {
		return lassuer;
	}
	public void setLassuer(String lassuer) {
		this.lassuer = lassuer;
	}
	
	
}
