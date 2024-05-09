package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

            InhousePart powerSupply = new InhousePart();
            powerSupply.setName("Power Supply");
            powerSupply.setPrice(3600.0);
            powerSupply.setInv(5);
            powerSupply.setPartId(1000);
            powerSupply.setMinInv(3);
            powerSupply.setMaxInv(20);

            InhousePart sensorArr = new InhousePart();
            sensorArr.setName("Sensor Array");
            sensorArr.setPrice(2900.0);
            sensorArr.setInv(5);
            sensorArr.setPartId(1100);
            sensorArr.setMinInv(3);
            sensorArr.setMaxInv(20);

            InhousePart heavyShielding = new InhousePart();
            heavyShielding.setName("Heavy Shielding");
            heavyShielding.setPrice(5100.0);
            heavyShielding.setInv(5);
            heavyShielding.setPartId(1200);
            heavyShielding.setMinInv(3);
            heavyShielding.setMaxInv(20);

            inhousePartRepository.save(powerSupply);
            inhousePartRepository.save(sensorArr);
            inhousePartRepository.save(heavyShielding);

            OutsourcedPart sawArm = new OutsourcedPart();
            sawArm.setName("Saw Arm");
            sawArm.setPrice(2000.0);
            sawArm.setInv(5);
            sawArm.setCompanyName("PKD Lumber");
            sawArm.setMinInv(3);
            sawArm.setMaxInv(20);

            OutsourcedPart syringeArm = new OutsourcedPart();
            syringeArm.setName("Syringe Arm");
            syringeArm.setPrice(1800.0);
            syringeArm.setInv(5);
            syringeArm.setCompanyName("Dr. Fred's Syringe Emporium");
            syringeArm.setMinInv(3);
            syringeArm.setMaxInv(20);

            outsourcedPartRepository.save(sawArm);
            outsourcedPartRepository.save(syringeArm);

            Set<Part> personalBotParts = new HashSet<>();
            personalBotParts.add(powerSupply);
            personalBotParts.add(sensorArr);
            personalBot.setParts(personalBotParts);
            productRepository.save(personalBot);

            Set<Part> constructorBotParts = new HashSet<>();
            constructorBotParts.add(powerSupply);
            constructorBotParts.add(sensorArr);
            constructorBotParts.add(sawArm);
            constructorBot.setParts(constructorBotParts);
            productRepository.save(constructorBot);

            Set<Part> securityBotParts = new HashSet<>();
            securityBotParts.add(powerSupply);
            securityBotParts.add(sensorArr);
            securityBotParts.add(sawArm);
            securityBotParts.add(syringeArm);
            securityBot.setParts(securityBotParts);
            productRepository.save(securityBot);

            Set<Part> healthBotParts = new HashSet<>();
            healthBotParts.add(powerSupply);
            healthBotParts.add(sensorArr);
            healthBotParts.add(syringeArm);
            healthBot.setParts(healthBotParts);
            productRepository.save(healthBot);

            Set<Part> hazardBotParts = new HashSet<>();
            hazardBotParts.add(powerSupply);
            hazardBotParts.add(sensorArr);
            hazardBotParts.add(heavyShielding);
            hazardBot.setParts(hazardBotParts);
            productRepository.save(hazardBot);

            Set<Product> powerSupplyProducts = new HashSet<>();
            powerSupplyProducts.add(personalBot);
            powerSupplyProducts.add(constructorBot);
            powerSupplyProducts.add(securityBot);
            powerSupplyProducts.add(healthBot);
            powerSupplyProducts.add(hazardBot);
            powerSupply.setProducts(powerSupplyProducts);
            inhousePartRepository.save(powerSupply);

            Set<Product> sensorArrProducts = new HashSet<>();
            sensorArrProducts.add(personalBot);
            sensorArrProducts.add(constructorBot);
            sensorArrProducts.add(securityBot);
            sensorArrProducts.add(healthBot);
            sensorArrProducts.add(hazardBot);
            sensorArr.setProducts(sensorArrProducts);
            inhousePartRepository.save(sensorArr);

            Set<Product> sawArmProducts = new HashSet<>();
            sawArmProducts.add(constructorBot);
            sawArmProducts.add(securityBot);
            sawArm.setProducts(sawArmProducts);
            outsourcedPartRepository.save(sawArm);

            Set<Product> syringeArmProducts = new HashSet<>();
            syringeArmProducts.add(securityBot);
            syringeArmProducts.add(healthBot);
            syringeArm.setProducts(syringeArmProducts);
            outsourcedPartRepository.save(syringeArm);

            Set<Product> heavyShieldingProducts = new HashSet<>();
            heavyShieldingProducts.add(hazardBot);
            heavyShielding.setProducts(heavyShieldingProducts);
            inhousePartRepository.save(heavyShielding);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
