//package market.aspect;
//
//import market.aspect.annotationHandler.ValidateParameters;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Parameter;
//
//@Aspect
//@Component
//public class CheckExistAspect {
//    private static final String POINTCUT_METHOD = "execution(* *(.., Long, ..))";
//    ValidateParameters validator;
//
//    @Autowired
//    public CheckExistAspect(ValidateParameters validator) {
//        this.validator = validator;
//    }
//
//    @Pointcut(POINTCUT_METHOD)
//    public void methodAnnotatedWithViewEvent() {
//    }
//
//    @Before("methodAnnotatedWithViewEvent()")
//    public void validateParameters(JoinPoint joinPoint) throws Throwable {
//
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        String methodName = signature.getMethod().getName();
//        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
//        Parameter[] parameters = joinPoint.getTarget().getClass().getMethod(methodName,parameterTypes).getParameters();
//        Object[] args = joinPoint.getArgs();
//
//        for (int i = 0; i < parameters.length; i++) {
//            Annotation[] annotations = parameters[i].getAnnotations();
//            Object arg = args[i];
//            validator.validateParameters(arg, annotations);
//        }
//    }
//}
