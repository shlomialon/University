package basic_concepts;

/*
This program shows how to use the default modifiers available in java : 
1. Default - if you do not define any modifier to any method or property, 
it is default modifier. The scope of this method/property is accessible to all 
classes within same package
2. Public - Methods and Properties defined using public modifier are accessible within packages
and outside packages
3. Protected - Methods and Properties defined using protectegd modifier are 
accessible within packages
and within inherited classes only
4. Private - Methods and Properties defined using private modifier are accessible only within
the class where they are declared.
*/
public class Package {
  //default access modifier
  int defaultNumber = 0;

/*
Public Modifier
*/
  public static String PublicMethod()
  {
      return "This is a public method";
  }
/*
Private Modifier
*/
  private static String PrivateMethod()
  {
      return "This is a private method";
  }
/*
Protected Modifier
*/
  protected static String ProtectedMethod()
  {
      return "This is a protected method";
  }
  public static void main(String[] args) {
    String newLine = System.getProperty("line.separator");
    System.out.println("Message returned from Public Method : " + PublicMethod() + newLine);
    System.out.println("Message returned from Private Method : " + PrivateMethod() + newLine);
    System.out.println("Message returned from Protected Method : " + ProtectedMethod() + newLine);
  }
}

