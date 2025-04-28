package my.code.demo_excel;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/numbers")
public class NumberController {

    private final NumberService numberService;

    public NumberController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/nth-min")
    public Integer getNumberMin(@RequestParam String filePath, @RequestParam int n) throws IOException {
        return numberService.findNthMinimum(filePath, n);
    }

}
