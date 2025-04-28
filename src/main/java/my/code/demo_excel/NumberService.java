package my.code.demo_excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.PriorityQueue;

@Service
public class NumberService {

    public Integer findNthMinimum(String filePath, int n) throws IOException {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(n);

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            var sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getPhysicalNumberOfCells() > 0) {
                    int number = (int) row.getCell(0).getNumericCellValue();
                    if (minHeap.size() < n) {
                        minHeap.offer(number);
                    } else if (number < minHeap.peek()) {
                        minHeap.poll();
                        minHeap.offer(number);
                    }
                }
            }
        }
        return minHeap.peek();
    }
}
