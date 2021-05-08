package employee_signup_processing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {

	public static void main(String[] args) {
		List<EmployeeOutputModel> modelList = readExcel();
		generateCsv(modelList);
	}

	public static void generateCsv(List<EmployeeOutputModel> modelList) {
		try (PrintWriter writer = new PrintWriter(new File("Supply List 2019-2020_generated.csv"))) {
			StringBuilder sb = new StringBuilder();

			generateHeader(sb);
			for (EmployeeOutputModel model : modelList) {
				writeRowData(model, sb);
			}

			writer.write(sb.toString());

			System.out.println("done!");

		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void generateHeader(StringBuilder sb) {
		sb.append("Last Name,");
		sb.append("First Name,");
		sb.append("Emp #,");
		sb.append("List,");
		sb.append("List Order,");
		sb.append("Home Phone,");
		sb.append("Cell Phone,");
		sb.append("Work Phone,");
		sb.append("Other Phone,");
		sb.append("Aboriginal Cultures & Traditions,");
		sb.append("African Heritage,");
		sb.append("ESL/LINC,");
		sb.append("Essential Skills Upgrading (ESU),");
		sb.append("Intern'l Languages,");
		sb.append("Parenting,");
		sb.append("Seniors Daytime,");
		sb.append("N,");
		sb.append("E,");
		sb.append("S,");
		sb.append("W,");
		sb.append("M - F (AM),");
		sb.append("M - F (PM),");
		sb.append("M - F (EVE),");
		sb.append("Sat (AM),");
		sb.append("Sat (PM),");
		sb.append("Sun (AM),");
		sb.append("Sun (PM),");
		sb.append("Language,");
		sb.append("Seniors,");
		sb.append("Note");
		sb.append('\n');
	}

	public static String getValueNullExcluded(String value) {
		return value == null ? "" : value;
	}

	public static void writeRowData(EmployeeOutputModel rowData, StringBuilder sb) {
		sb.append(getValueNullExcluded(rowData.getLastName()) + ",");
		sb.append(getValueNullExcluded(rowData.getFirstName()) + ",");
		sb.append(rowData.getEmployeeNum() + ",");
		sb.append(getValueNullExcluded(rowData.getList()) + ",");
		sb.append(rowData.getListOrder() + ",");
		sb.append(rowData.getHomePhone() + ",");
		sb.append(rowData.getCellPhone() + ",");
		sb.append(rowData.getWorkPhone() + ",");
		sb.append(rowData.getOtherPhone() + ",");
		sb.append(getValueNullExcluded(rowData.getAboriginalCulturesTraditions()) + ",");
		sb.append(getValueNullExcluded(rowData.getAfricanHeritage()) + ",");
		sb.append(getValueNullExcluded(rowData.getEslLinc()) + ",");
		sb.append(getValueNullExcluded(rowData.getEsu()) + ",");
		sb.append(getValueNullExcluded(rowData.getInternationalLang()) + ",");
		sb.append(getValueNullExcluded(rowData.getParenting()) + ",");
		sb.append(getValueNullExcluded(rowData.getSeniorsDaytime()) + ",");
		sb.append(getValueNullExcluded(rowData.getN()) + ",");
		sb.append(getValueNullExcluded(rowData.getE()) + ",");
		sb.append(getValueNullExcluded(rowData.getS()) + ",");
		sb.append(getValueNullExcluded(rowData.getW()) + ",");
		sb.append(getValueNullExcluded(rowData.getMfam()) + ",");
		sb.append(getValueNullExcluded(rowData.getMfpm()) + ",");
		sb.append(getValueNullExcluded(rowData.getMfeve()) + ",");
		sb.append(getValueNullExcluded(rowData.getSatam()) + ",");
		sb.append(getValueNullExcluded(rowData.getSatpm()) + ",");
		sb.append(getValueNullExcluded(rowData.getSunam()) + ",");
		sb.append(getValueNullExcluded(rowData.getSunpm()) + ",");
		sb.append(getValueNullExcluded(rowData.getLanguage()) + ",");
		sb.append(getValueNullExcluded(rowData.getSeniors()) + ",");
		sb.append(getValueNullExcluded(rowData.getNotes()) + ",");
		sb.append('\n');
	}
	
	public static String getCellData(Cell cell) {
		try {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				return cell.getStringCellValue().trim();
			case Cell.CELL_TYPE_NUMERIC:
				String tempString = "";
				if(cell.getNumericCellValue() >= 2147483647) {
					tempString =  cell.getNumericCellValue() + "";
				}else {
					tempString =  Integer.toString((int)cell.getNumericCellValue()); //cell.getNumericCellValue() + "";
				}
				
				if (tempString.isEmpty()){
					return "0";
				}else {
					return tempString;
				}
			case Cell.CELL_TYPE_ERROR:
				return cell.getStringCellValue().trim();
			case Cell.CELL_TYPE_FORMULA:
				return cell.getStringCellValue().trim();
			default:
				return cell.getStringCellValue().trim();
			}
		}catch (IllegalStateException e) {
			// do nothing
		}
		return "";
	}

	public static List<EmployeeOutputModel> readExcel() {
		List<EmployeeOutputModel> outputList = new ArrayList<>();
		try {

			File myFile = new File(
					"C:\\Users\\Cometstrike\\eclipse-workspace\\employee_signup_processing\\(RAW DATA - FINAL) Supply List 2020 - 2021.xlsx");
			FileInputStream fis = new FileInputStream(myFile);
			XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);
			XSSFSheet mySheet = myWorkBook.getSheetAt(0);
			Iterator<Row> rowIterator = mySheet.iterator();
			int i = 0;
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				boolean duplicateModel = false;
				Iterator<Cell> cellIterator = row.cellIterator();
				EmployeeOutputModel model = new EmployeeOutputModel();
				if (i != 0) {
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						
						if (cell.getCellType() != Cell.CELL_TYPE_ERROR) {
							switch (cell.getColumnIndex()) {
							case 2:// EMP #:
								try {
									System.out.print("Employee Num=" + getCellData(cell) + "\t");
									model.setEmployeeNum(getCellData(cell).isEmpty() ? 0 : Integer.parseInt(getCellData(cell)));
								} catch (IllegalStateException e) {
									// do nothing
								}

								break;
							case 0:// Employee Last Name
								try {
									System.out.print("Employee Last Name=" + getCellData(cell) + "\t");
									model.setLastName(getCellData(cell));
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 1:// Employee First Name
								try {
									System.out.print("Employee First Name=" + getCellData(cell) + "\t");
									model.setFirstName(getCellData(cell));
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 3:// Seniority List
								try {
									System.out.print("SAP=" + getCellData(cell) + "\t");
									model.setList(getCellData(cell));
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 4:// List Order
								try {
									System.out.print("List Order=" + cell.getNumericCellValue() + "\t");
									model.setListOrder((int)cell.getNumericCellValue());
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 5:// Home Phone
								try {
									System.out.print("Home Phone=" + getCellData(cell) + "\t");
									model.setHomePhone(getCellData(cell));
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 6:// Cell Phone
								try {
									System.out.print("Cell Phone=" + getCellData(cell) + "\t");
									model.setCellPhone(getCellData(cell));
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 7:// Work Num
								try {
									System.out.print("Work Num=" + getCellData(cell) + "\t");
									model.setWorkPhone(getCellData(cell));
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 8:// Other Phone Num
								try {
									System.out.print("Other Phone Num=" + getCellData(cell) + "\t");
									model.setOtherPhone(getCellData(cell));
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 9:// O column
								try {
									System.out.print("supply list check=" + cell.getStringCellValue() + "\t");
									String[] splittedSupplys = cell.getStringCellValue().split(",");
									for (String splittedSupply : splittedSupplys) {
										if ("ESU".equalsIgnoreCase(splittedSupply.trim())) {
											model.setEsu("X");
										}
										if ("ESL/LINC".equalsIgnoreCase(splittedSupply.trim())) {
											model.setEslLinc("X");
										}
										if ("International Languages".equalsIgnoreCase(splittedSupply.trim())) {
											model.setInternationalLang("X");
										}
										if ("African Heritage".equalsIgnoreCase(splittedSupply.trim())) {
											model.setAfricanHeritage("X");
										}
										if ("Seniors' Daytime".equalsIgnoreCase(splittedSupply.trim())) {
											model.setSeniorsDaytime("X");
										}
										if("Parenting Centres".equalsIgnoreCase(splittedSupply.trim())){
											model.setParenting("X");
										}
									}
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 10:// P column
								try {
									System.out.print("language=" + cell.getStringCellValue() + "\t");
									String[] splittedLangs = cell.getStringCellValue().split(",");
									if(splittedLangs.length > 1) {
										duplicateModel = true;
									}
//									String reconstructed = "";
//									if(splittedLangs.length > 1) {
//										reconstructed = "\"" + cell.getStringCellValue() + "\"";
//									}else {
//										reconstructed = cell.getStringCellValue();
//									}
									//split later into different models...
									model.setLanguage(cell.getStringCellValue());
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 11:// Q column
								try {
									System.out.print("Region=" + cell.getStringCellValue() + "\t");
									String[] splittedRegions = cell.getStringCellValue().split(",");
									for (String splittedRegion : splittedRegions) {
										if ("North Region".equalsIgnoreCase(splittedRegion.trim())) {
											model.setN("X");
										}
										if ("South Region".equalsIgnoreCase(splittedRegion.trim())) {
											model.setS("X");
										}
										if ("East Region".equalsIgnoreCase(splittedRegion.trim())) {
											model.setE("X");
										}
										if ("West Region".equalsIgnoreCase(splittedRegion.trim())) {
											model.setW("X");
										}
									}
								} catch (IllegalStateException e) {
									// do nothing
								}
								break;
							case 12: // R Column
								try {
									System.out.print("Schedule=" + cell.getStringCellValue() + "\t");
									String[] splittedSchedules = cell.getStringCellValue().split(",");
									for (String splittedSchedule : splittedSchedules) {
										if ("Monday - Friday (Morning)".equalsIgnoreCase(splittedSchedule.trim())) {
											model.setMfam("X");
										}
										if ("Monday - Friday (Afternoon)".equalsIgnoreCase(splittedSchedule.trim())) {
											model.setMfpm("X");
										}
										if ("Monday - Friday (Evening)".equalsIgnoreCase(splittedSchedule.trim())) {
											model.setMfeve("X");
										}
										if ("Saturday (Morning)".equalsIgnoreCase(splittedSchedule.trim())) {
											model.setSatam("X");
										}
										if ("Saturday (Afternoon)".equalsIgnoreCase(splittedSchedule.trim())) {
											model.setSatpm("X");
										}
										if ("Sunday (Morning)".equalsIgnoreCase(splittedSchedule.trim())) {
											model.setSunam("X");
										}
										if ("Sunday (Afternoon)".equalsIgnoreCase(splittedSchedule.trim())) {
											model.setSunpm("X");
										}
									}
									
								} catch (IllegalStateException e) {
									// do nothing
								}
							default:
							}
						}
					}
				}
				i++;
				System.out.println("");
				if(duplicateModel) {
					String langList = model.getLanguage();
					
					langList = langList.replace(" And ", ",");
					langList = langList.replace(" and ", ",");
					String[] langListArray = langList.split(",");
					for(String lang : langListArray) {
						if(!lang.isEmpty()) {
							EmployeeOutputModel modelCopy = (EmployeeOutputModel)model.clone();
							int newLength = langListArray.length;
							 
							String[] copiedArray = Arrays.copyOf(langListArray, newLength);
							List<String> list = new ArrayList<String>(Arrays.asList(copiedArray));
							list.remove(lang);
							list.add(0, lang);
							copiedArray = list.toArray(new String[0]);
							
							String finalLangString = "\"";
							int d = 0;
							for(String ele :copiedArray) {
								d++;
								if(d == newLength) {
									finalLangString = finalLangString + ele;
								}else {
									finalLangString = finalLangString + ele + ",";
								}
							}
							finalLangString += "\"";
//							modelCopy.setLanguage(lang);
							modelCopy.setLanguage(finalLangString);
							outputList.add(modelCopy);
						}
					}
				}else {
					outputList.add(model);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return outputList;
	}

	public static EmployeeOutputModel generateSampleCsvData() {
		EmployeeOutputModel model = new EmployeeOutputModel();
		return model;
	}

}
