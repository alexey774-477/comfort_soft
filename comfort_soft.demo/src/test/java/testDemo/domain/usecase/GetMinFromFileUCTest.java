package testDemo.domain.usecase;

import org.junit.jupiter.api.Test;
import testDemo.application.exepction.UseCaseException;
import testDemo.domain.usecase.impl.GetMinFromFileUCImpl;
import testDemo.ports.impl.LocalFilePortImpl;

import static org.junit.jupiter.api.Assertions.*;

class GetMinFromFileUCTest {
    private static final String XSLX_FILE_PATH = "./src/main/resources/xlsx/sample_1.xlsx";

    private testDemo.domain.usecase.GetMinFromFileUC useCase = new GetMinFromFileUCImpl(new LocalFilePortImpl());

    @Test
    void getMinFromFileUC() {
        int minFromFileUC = useCase.getMinFromFileUC(XSLX_FILE_PATH, 5);

        assertEquals(1, minFromFileUC);
    }

    @Test
    void shouldRaiseException() {
        UseCaseException useCaseException = assertThrows(UseCaseException.class, () -> useCase.getMinFromFileUC("", 5));
        assertEquals(useCaseException.getLayout(), UseCaseException.LAYER);
    }

}