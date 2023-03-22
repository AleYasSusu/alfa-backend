package ages.alfa.service;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface StudentStatsExcelExporterService {

    void write();

    XSSFWorkbook getWorkbook();

}
