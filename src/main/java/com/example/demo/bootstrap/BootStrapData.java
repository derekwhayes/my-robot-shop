package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            System.out.println(part.getName() + " " + part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        if (productRepository.count() == 0) {
            Product personalBot = new Product("Personal Bot", 15000, 5);
            Product constructorBot = new Product("Constructor Bot", 30000, 5);
            Product securityBot = new Product("Security Bot", 35000, 5);
            Product healthBot = new Product("Health Bot", 35000, 5);
            Product hazardBot = new Product("Hazard Bot", 40000, 5);

            productRepository.save(personalBot);
            productRepository.save(constructorBot);
            productRepository.save(securityBot);
            productRepository.save(healthBot);
            productRepository.save(hazardBot);
        }

        if (inhousePartRepository.count() == 0) {
            InhousePart powerSupply = new InhousePart();
            powerSupply.setName("Power Supply");
            powerSupply.setPrice(3600.0);
            powerSupply.setInv(5);
            powerSupply.setPartId(1000);

            InhousePart sensorArr = new InhousePart();
            sensorArr.setName("Sensor Array");
            sensorArr.setPrice(2900.0);
            sensorArr.setInv(5);
            sensorArr.setPartId(1100);

            InhousePart heavyShielding = new InhousePart();
            heavyShielding.setName("Heavy Shielding");
            heavyShielding.setPrice(5100.0);
            heavyShielding.setInv(5);
            heavyShielding.setPartId(1200);

            inhousePartRepository.save(powerSupply);
            inhousePartRepository.save(sensorArr);
            inhousePartRepository.save(heavyShielding);
        }

        if (outsourcedPartRepository.count() == 0) {
            OutsourcedPart sawArm = new OutsourcedPart();
            sawArm.setName("Saw Arm");
            sawArm.setPrice(2000.0);
            sawArm.setInv(5);
            sawArm.setCompanyName("PKD Lumber");

            OutsourcedPart syringeArm = new OutsourcedPart();
            syringeArm.setName("Syringe Arm");
            syringeArm.setPrice(1800.0);
            syringeArm.setInv(5);
            syringeArm.setCompanyName("Dr. Fred's Syringe Emporium");

            outsourcedPartRepository.save(sawArm);
            outsourcedPartRepository.save(syringeArm);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
