package Good.www.Good.com.core;

import java.util.logging.*;
import org.xillium.core.*;
import org.xillium.data.*;
import org.xillium.data.validation.*;
import org.xillium.data.persistence.*;
import Good.www.Good.com.*;
import Good.www.Good.com.core.util.*;


/**
 * Service description.
 */
public class Hello implements Service {
    private static final Logger _logger = Logger.getLogger(Hello.class.getName());

    public static class Request implements DataObject {
        public String name;
    }

    /**
     * Service
     */
    public DataBinder run(DataBinder binder, Reifier reifier, Persistence persist) throws ServiceException {
        try {
            Request request = reifier.collect(new Request(), binder);
            binder.put("greeting", "Hello " + (request.name != null ? request.name : "World"));
        } catch (Exception x) {
            throw new ServiceException(x.getMessage(), x);
        }

        return binder;
    }
}
