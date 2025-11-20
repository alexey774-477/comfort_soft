package testDemo.domain.usecase.impl;

import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import testDemo.application.annotation.UseCase;
import testDemo.application.exepction.UseCaseException;
import testDemo.ports.LocalFilePort;


import java.io.FileInputStream;

@UseCase
@RequiredArgsConstructor
public class GetMinFromFileUCImpl implements testDemo.domain.usecase.GetMinFromFileUC {

    private final LocalFilePort filePort;

    @Override
    public Integer getMinFromFileUC(String path, int boundary) {
        try {
            FileInputStream fileInputStream = filePort.fileStream(path);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheetAt(0);

            int lastRowIndex = sheet.getLastRowNum();

            if (lastRowIndex == -1) {
                throw new UseCaseException(new RuntimeException("Sheet is empty"));
            }

            int totalRows = lastRowIndex + 1;
            int rowsToRead = boundary < totalRows ? boundary : totalRows;

            int[] array = getIntArray(sheet, rowsToRead);

            int min = array[0];
            for (int i = 1; i < rowsToRead; i++) {
                if (array[i] < min) {
                    min = array[i];
                }
            }

            return min;

        } catch (Exception e) {
            throw new UseCaseException(e);
        }
    }

    private int[] getIntArray(Sheet sheet, int boundary) {
        int[] array = new int[boundary];
        for (int i = 0; i < boundary; i++) {
            Row row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            int value = (int) cell.getNumericCellValue();
            array[i] = value;
        }
        return array;
    }
    // в методе getIntArray можно еще сделать проверку на то, являются ли данные в файле числами, и есть ли там N количество чисел.
}
