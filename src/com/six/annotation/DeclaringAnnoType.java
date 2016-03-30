package com.six.annotation;

import java.lang.annotation.Documented;

/**
 * Created by hellenxu on 16/3/29.
 * example of declaring an annotation type
 */

@Documented
@interface ClassPreamble {
    String author();
    String date();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
    String[] reviewers();
}

@ClassPreamble(
        author = "hellenxu",
        date = "3/29/2016",
        currentRevision = 6,
        lastModified = "3/12/2016",
        lastModifiedBy = "Szw",
        reviewers = {"Emma", "Cindy"}
)
public class DeclaringAnnoType {
    //class code goes here
}
