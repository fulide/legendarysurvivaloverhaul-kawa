public class VerifyClasses {
    public static void main(String[] args) throws Exception {
        for (String n : args) {
            Class<?> c = Class.forName(n, false, VerifyClasses.class.getClassLoader());
            System.out.println("loaded+linked: " + c.getName());
        }
    }
}
