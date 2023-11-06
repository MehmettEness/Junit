package J06_Junit;

import org.junit.*;

public class C02_BeforeAfter {


    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("@BeforeClass Class'dan önce 1 kez çalışır");

    }

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before Her test methodundan önce 1 kez çalışır");

    }

    @Test
    public void test01() {
        System.out.println("Test01 çalıştı");


    }
    @Test
    public void test02() {
        System.out.println("Test02 çalıştı");


    }
    @Test
    public void test03() {
        System.out.println("Test03 çalıştı");


    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After Her Test methodundan sonra 1 kez çalışır");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("@AfterClass classdan sonra 1 kez çalışır");
    }
}
