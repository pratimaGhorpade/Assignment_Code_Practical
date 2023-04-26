/*
package Utils;

import com.absli.utils.PropertiesUtils;

import java.io.File;
import java.util.*;

public class Runner {


        public static String PLATFORM;
        public static String BROWSER;
        public static String INSTANCE;
        static PropertiesUtils prop = new PropertiesUtils();
        public static File ReportsFolder = new File(System.getProperty("user.dir")+"/Reports");
        public static Map<String, DeviceContext> allDeviceContexts = new HashMap<String, DeviceContext>();
        public static Map<String,String> testngParams = new HashMap<String,String> ();
        public static ArrayList<String> array1 = new ArrayList<>();
        public static ArrayList<String> array2 = new ArrayList<>();
        public static ArrayList<String> array3 = new ArrayList<>();
        public static int threadCount = 2;
        static int instanceCount = 1;
        static String HEADLESS_MODE = "true";

        CommonUtils utils = new CommonUtils();

        public static void main(String args[]) throws Exception {
                TestRunner runExecution = new TestRunner();
                PLATFORM = ExcelUtils.getPlatformNameFromExcel(prop.getProperties("testExcelSheet"), "controller");
                INSTANCE = ExcelUtils.getInstanceCountFromExcel(prop.getProperties("testExcelSheet"), "controller");

                System.out.println("INSTANCE --------->"+INSTANCE);
                try {
                        instanceCount = Integer.parseInt(INSTANCE);
                } catch (NumberFormatException e) {
                        //
                }

                System.out.println("Platform:========" + PLATFORM);
                switch (PLATFORM.toLowerCase()) {
                        case "web":
                                BROWSER = ExcelUtils.getBrowserNameFromExcel(prop.getProperties("testExcelSheet"), "controller");
                                //This Map can hold your testng Parameters.
                                testngParams.put("platformType","web");
                                testngParams.put("platformName",BROWSER);
                                testngParams.put("appType","native");
                                testngParams.put("runType","local");
                                testngParams.put("env","qa");
                                testngParams.put("headless",HEADLESS_MODE);
                                runExecution.runTestNGTestWeb(testngParams);
                                break;
                        case "android":
                                //This Map can hold your testng Parameters.
                                runExecution.runTestNGTestAndroid();
                                break;
                        case "ios" :
                                runExecution.runTestNGTestIOS();
                                break;
                        case "all" :
                                runExecution.runAllTestNGTests();
                                break;
                        case "mobile" :
                                runExecution.runMobileTestNGTests();
                                break;
                        case "iosbrowser":
                                runExecution.runTestNGTestIOSSafari();
                                break;
                        case "androidbrowser":
                                runExecution.runTestNGTestAndroidChrome();
                                break;
                        default:
                                System.out.println("invalid platform");
                }

                System.exit(0);

        }

        private void runAllTestNGTests() throws Exception {
                BROWSER = ExcelUtils.getBrowserNameFromExcel(prop.getProperties("testExcelSheet"), "controller");
                //This Map can hold your testng Parameters.
                testngParams.put("platformType","web");
                testngParams.put("platformName",BROWSER);
                testngParams.put("appType","native");
                testngParams.put("runType","local");
                testngParams.put("env","qa");
                testngParams.put("headless",HEADLESS_MODE);
                runTestNGTestWeb(testngParams);

                runTestNGTestIOS();

                runTestNGTestAndroid();
        }

        public void runTestNGTestWeb(Map<String, String> testngParams) throws Exception {

                // Create an instance on TestNG
                TestNG myTestNG = new TestNG();

                // Create an instance of XML Suite and assign a name for it.
                XmlSuite mySuite = new XmlSuite();
                mySuite.setName("Web Suite_"+utils.getCurrentTimeStamp());
                mySuite.setParallel(XmlSuite.ParallelMode.TESTS);
                mySuite.setConfigFailurePolicy(XmlSuite.FailurePolicy.valueOf("CONTINUE"));
                mySuite.addListener("com.absli.listeners.TestLevelDriverCreator");

                if (INSTANCE.equalsIgnoreCase("1")) {
                        mySuite.setParallel(XmlSuite.ParallelMode.NONE);
                }
                // Create a list which can contain the classes that you want to run.

                // get suites list from excel
                ArrayList<String> mySuiteData = new ArrayList<String>();
                mySuiteData = ExcelUtils.getExecutionSuitesFromController(prop.getProperties("testExcelSheet"), "controller");
                System.out.println("my suites =============" + mySuiteData);

                //Create a list of XmlTests and add the Xmltest you created earlier to it.
                List<XmlTest> myTests = new ArrayList<XmlTest>();
                for(String suite:mySuiteData) {
                        List<Map<String, String>> myClassNamesHashMap = ExcelUtils.getExecutionClassMethodNames(prop.getProperties("testExcelSheet"), suite);
                        //Create an instance of XmlTest and assign a name for it.
                        XmlTest myTest = new XmlTest(mySuite);
                        myTest.setName("Web Test On- "+BROWSER+"-"+suite);

                        //Add any parameters that you want to set to the Test.
                        myTest.setParameters(testngParams);
                        //Print the parameter values
                        Map<String,String> params = myTest.getAllParameters();
                        for(Map.Entry<String,String> entry : params.entrySet())
                        {
                                System.out.println(entry.getKey() + " => " + entry.getValue());
                        }

                        int regionIndex = 1;

                        // get Iterator for looping through AL
                        Iterator<Map<String, String>> iterator =
                                myClassNamesHashMap.iterator();

                        // iterate AL using while-loop
                        while(iterator.hasNext()) {

                                Map<String, String> region = iterator.next();

                                // getting entrySet() into Set
                                Set<Map.Entry<String, String>> entrySet =
                                        region.entrySet();

                                // for-each loop
                                for(Map.Entry<String, String> set : entrySet) {

                                        System.out.println("class : " + set.getKey()
                                                + "\tmethod : " + set.getValue());
                                        XmlClass myClass = new XmlClass(set.getKey());
                                        List<XmlInclude> myMethods = new ArrayList<>();
                                        myMethods.add(new XmlInclude(set.getValue()));
                                        myClass.setIncludedMethods(myMethods);
                                        myTest.getClasses().add(myClass);
                                }

                                // increment region index by 1
                                regionIndex++;
                        }
                        myTests.add(myTest);
                }

        }*/
