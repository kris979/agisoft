/* 
  * ============================================================================ 
  * Name      : AgisoftAnnotationsProcessor.java
  * ============================================================================
  */
package annotations;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;


/**
 * 
 *
 */
@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class AgisoftAnnotationsProcessor extends AbstractProcessor {

    /**
     * 
     */
    public AgisoftAnnotationsProcessor() {
        super();
    }

    /* (non-Javadoc)
     * @see javax.annotation.processing.AbstractProcessor#process(java.util.Set, javax.annotation.processing.RoundEnvironment)
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement typeElement : annotations) {
            System.out.println(typeElement.getQualifiedName());
        }
        return true;
    }

}
