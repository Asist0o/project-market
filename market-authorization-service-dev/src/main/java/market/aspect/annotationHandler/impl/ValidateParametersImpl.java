//package market.aspect.annotationHandler.impl;
//
//import lombok.AllArgsConstructor;
//import market.aspect.annotationHandler.ValidateParameters;
//import market.service.CheckExistService;
//import market.validate.CheckExist;
//import org.springframework.stereotype.Component;
//
//import javax.xml.bind.ValidationException;
//import java.lang.annotation.Annotation;
//
//@AllArgsConstructor
//@Component
//public class ValidateParametersImpl<T> implements ValidateParameters {
//
//    private final CheckExistService<T> existService;
//
//    @Override
//    public void validateParameters(Object arg, Annotation[] annotations) throws ValidationException {
//        for (int i = 0, annotationsLength = annotations.length; i < annotationsLength; i++) {
//            Annotation annotation = annotations[i];
//            if (annotation instanceof CheckExist) {
//                Long id = (Long) arg;
//                String entityName = ((CheckExist) annotation).value().getName();
//                if (!existService.checkExistsEntity(id)) {
//                    throw new ValidationException("Entity - %s with id - %s not exist".formatted(entityName, id));
//                }
//            }
//        }
//
//    }
//}
