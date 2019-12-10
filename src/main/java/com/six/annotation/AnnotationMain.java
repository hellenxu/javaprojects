package main.java.com.six.annotation;

import java.lang.reflect.Method;

/**
 * Created by Xiaolin on 2016-07-07.
 */

public class AnnotationMain {

    @HelloAnnotation(greeting = "Good Morning")
    public static void main(String[] args){
        System.out.println("Using custom annotation...");
        Class clz = AnnotationMain.class;
        for(Method method : clz.getMethods()){
            HelloAnnotation helloAnn = method.getAnnotation(HelloAnnotation.class);
            if(helloAnn != null){
                System.out.println(helloAnn.greeting());
            }
        }
    }
}
