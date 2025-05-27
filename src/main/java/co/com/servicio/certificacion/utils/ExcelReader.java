package co.com.servicio.certificacion.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReader {

    public static List<Map<String, String>> leerDatos(String rutaArchivo, String hoja) {
        List<Map<String, String>> datos = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(new File(rutaArchivo));
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheet(hoja);
            Row headerRow = sheet.getRow(0);

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row currentRow = sheet.getRow(i);
                Map<String, String> data = new HashMap<>();

                for (int j = 0; j < currentRow.getLastCellNum(); j++) {
                    Cell cell = currentRow.getCell(j);
                    Cell headerCell = headerRow.getCell(j);

                    String header = headerCell.getStringCellValue();
                    String value = "";

                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                value = cell.getStringCellValue();
                                break;
                            case NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    value = cell.getDateCellValue().toString();
                                } else {
                                    value = String.valueOf((long) cell.getNumericCellValue()); // sin decimales
                                }
                                break;
                            case BOOLEAN:
                                value = String.valueOf(cell.getBooleanCellValue());
                                break;
                            case FORMULA:
                                value = cell.getCellFormula(); // opcionalmente podrías evaluarla
                                break;
                            case BLANK:
                                value = "";
                                break;
                            default:
                                value = "";
                        }
                    }

                    data.put(header, value);
                }

                datos.add(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return datos;
    }
}
