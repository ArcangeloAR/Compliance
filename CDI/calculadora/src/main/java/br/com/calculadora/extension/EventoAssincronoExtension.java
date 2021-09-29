package br.com.calculadora.extension;

import java.lang.reflect.Method;
import java.util.List;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AnnotatedMethod;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;

import org.jboss.weld.bean.builtin.BeanManagerProxy;
import org.jboss.weld.event.ObserverMethodImpl;
import org.jboss.weld.injection.MethodInjectionPoint;
import org.jboss.weld.manager.BeanManagerImpl;

import br.com.calculadora.events.Assincrono;
import jakarta.enterprise.inject.spi.ObserverMethod;

/**
 *
 * @author gilliard
 */
public class EventoAssincronoExtension implements Extension {

    void afterBeanDiscovery(@Observes AfterBeanDiscovery abd, BeanManager bm) {

        BeanManagerImpl manager = ((BeanManagerProxy) bm).delegate();

        List<javax.enterprise.inject.spi.ObserverMethod<?>> observers = manager.getObservers();

        for (javax.enterprise.inject.spi.ObserverMethod<?> observerMethod : observers) {
            ObserverMethodImpl observerMethodImpl = (ObserverMethodImpl) observerMethod;

            MethodInjectionPoint methodInjectionPoint = observerMethodImpl.getMethod();

            AnnotatedMethod annotatedMethod = (AnnotatedMethod) methodInjectionPoint.getAnnotated();
            Method method = annotatedMethod.getJavaMember();

            if (method.isAnnotationPresent(Assincrono.class)) {

                ObserverMethod observerMethodWrapper = (ObserverMethod) new ObserverMethodWrapper((javax.enterprise.inject.spi.ObserverMethod) observerMethodImpl);

                observers.remove(observerMethodImpl);
                abd.addObserverMethod((javax.enterprise.inject.spi.ObserverMethod<?>) observerMethodWrapper);
            }
        }
    }
}
