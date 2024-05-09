# WESTERN GOVERNOR UNIVERSITY 
## D287 – JAVA FRAMEWORKS
Welcome to Java Frameworks! This is an opportunity for students to implement user interfaces and learn to leverage existing frameworks, assets, and content for object-oriented programming.
## CHANGELOG
Create a README file that includes notes describing where in the code to find the changes you made for each of parts C to J. Each note should include the prompt, file name, line number, and change.
### C. CUSTOMIZE THE HTML USER INTERFACE FOR YOUR CUSTOMER'S APPLICATION
>The user interface should include the shop name, the product names, and the names of the parts.
Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.

* mainscreen.html / line 14 / change title to "My Robot Shop"
* mainscreen.html / line 19 / change header to "My Robot Shop"
### D. ADD AN "ABOUT" PAGE TO THE APPLICATION
>Describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

* about.html / * / create about.html
* about.html / line 6 / add title "About | My Robot Shop"
* about.html / line 5 / add viewport meta
* about.html / line 9 / add Bootstrap link
* about.html / line 13 / add about blurb
* about.html / lin 18 / add home link button
* AboutController.java / * / create AboutController
* AboutController.java / line 5 / add Controller annotation
* AboutController.java / line 9 / add mapping for about page
* mainscreen.html / line 89 / add about us link button
### E. ADD A SAMPLE INVENTORY APPROPRIATE FOR YOUR CHOSEN STORE TO THE APPLICATION
>You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.
Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.

* BootStrapData.java / line 69 / add conditional..only add products if table is empty
* BootStrapData.java / line 70 / create 5 products
* BootStrapData.java / line 76 / save 5 products
* BootStrapData.java / line 81 / add conditional for InhouseParts 
* BootStrapData.java / line 82 / create 3 InhouseParts
* BootStrapData.java / line 100 / save 3 InhouseParts
* BootStrapData.java / line 105 / add conditional for OutsourcedParts
* BootStrapData.java / line 106 / create 2 OutsourcedParts
* BootStrapData.java / line 118 / save 2 OutsourcedParts
* BootStrapData.java / line 120 / set parts for different products
* BootStrapData.java / line 150 / set products for different parts
* application.properties / line 6 / iterate db number to clear testing data
### F. ADD A "BUY NOW" BUTTON TO YOUR PRODUCT LIST
>* The “Buy Now” button must be next to the buttons that update and delete products.  

* mainscreen.html / line 82 / add "Buy Now" button
* mainscreen.html / line 82 / add form for buy now submission
>* The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.  

* AddProductController.java / line 103 / add buyProduct method
* AddProductController.java / line 104 / call buyNow service
* AddProductController.java / line 105 / return result page
* ProductService.java / line 20 / add buyNow method
* ProductServiceImpl.java / line 71 / add buyNow method
* ProductServiceImpl.java / line 72 / find the product by ID
* ProductServiceImpl.java / line 73 / assing theProduct object with referenced Product
* ProductServiceImpl.java / line 74 / reduce inventory by 1
* ProductServiceImpl.java / line 75 / save update to database
>* Display a message that indicates the success or failure of a purchase.

* buyProduct.html / * / copy in about.html
* buyProduct.html / line 6 / change title
* buyProduct.html / line 14 / change header
* buyProduct.html / line 16 / change message
* ProductServiceImpl.java / line 71 / add return value boolean to indicate success or failure
* ProductServiceImpl.java / line 74 / add conditional to see if inventory > 0
* ProductServiceImpl.java / line 77 / return true if inv reduced
* ProductServiceImpl.java / line 79 / else return false
* AddProductController.java / line 104 / add conditional to check if inv reduction was successful
* AddProductController.java / line 105 / if true return success page
* AddProductController.java / line 107 / else return error page
### G. MODIFY THE PARTS TO TRACK MAXIMUM AND MINIMUM INVENTORY
>* Add additional fields to the part entity for maximum and minimum inventory.  

* Part.java / line 32 / add minInv field
* Part.java / line 34 / add maxInv field
* Part.java / line 44 / add new fields to constructor
* Part.java / line 52 / add new fields to constructor
* Part.java / line 101 / add getters and setters for new fields
* mainscreen.html / line 47 / add min and max columns to template
>* Modify the sample inventory to include the maximum and minimum fields.  

* BootStrapData / line 88 / set min and max for all parts
>* Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.  

* InhousePartForm.html / line 24 / add fields for minInv and maxInv
* OutsourcedPartForm.html / line 25 / add fields for minInv and maxInv
>* Rename the file the persistent storage is saved to.  

* application.properties / line 6 / rename database url
>* Modify the code to enforce that the inventory is between or at the minimum and maximum value.

* AddInhousePartController.java / line 42 / add check if inv is outside min-max range
* AddInhousePartController.java / line 44 / return to the form* Add
* InhousePartController.java / line 43 / assign an error msg
* AddOutsourcedPartController.java / line 44 / add the same conditional to the outsource controller
### H. ADD VALIDATION FOR BETWEEN OR AT THE MAXIMUM AND MINIMUM FIELDS
>* Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.  

* AddInhousePartController.java / line 42 / split conditional to display specific message for low inventory
* AddOutsourcedPartController.java / line 44 / split conditional to display specific message for low inventory
>* Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.  

* EnufPartsValidator.java / line 36 / change logic to check if minInv <= product inv
* ValidEnufParts.java / line 20 / change msg to indicate inventory is low
>*  Display error messages when adding and updating parts if the inventory is greater than the maximum.

* AddInhousePartController.java / line 46 / split conditional to display specific message for low inventory
* AddOutsourcedPartController.java / line 48 / split conditional to display specific message for low inventory
### I. ADD AT LEAST TWO UNIT TESTS FOR THE MAXIMUM AND MINIMUM FIELDS TO THE PartTest CLASS IN THE TEST PACKAGE

* PartTest.java / line 161 / create setMinInv()
* PartTest.java / line 162 / initialize test variable
* PartTest.java / line 163 / call setMinVal()
* PartTest.java / line 164 / test is minVal and actual minVal are equal
* PartTest.java / line 165 / repeat for partOut
* PartTest.java / line 170 / repeat for setMaxVal
### J. REMOVE THE CLASS FILES FOR ANY UNUSED VALIDATORS IN ORDER TO CLEAN YOU CODE
 
* DeletePartValidator / * / delete unused file