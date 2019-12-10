package main.java.com.six.annotation;

/**
 * Created by hellenxu on 16/3/30.
 * examples of predefined annotations
 */

public class PredefinedAnnotation {

    /**
     * @deprecated
     * no longer use string as the type of name
     */
    @Deprecated
    private static void deprecatedSetName(String name){
    }

    @SuppressWarnings("deprecation")
    void useDeprecatedMethod(){
        PredefinedAnnotation.deprecatedSetName("deprecated ann");
    }
}
