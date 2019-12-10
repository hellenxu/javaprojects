package main.java.com.six.annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created by Xiaolin on 2016-07-08.
 */
@SupportedAnnotationTypes("com.six.annotation.HelloAnnotation")
public class HelloProcessor extends AbstractProcessor{
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //something need to do during compiling process.
        System.out.println("Hello Annotation");
        return false;
    }
}
