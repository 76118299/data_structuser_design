package design.filterchan;

import java.util.ArrayList;
import java.util.List;

public class Servlet {
    class RequestP {
        String str;
    }

    class ResponseP {
        String Str;
    }

    interface Filter {
        boolean doFilter(RequestP requestP, ResponseP responseP, FilterChan filterChan);
    }

    class Filter1 implements Filter {

        public boolean doFilter(RequestP requestP, ResponseP responseP, FilterChan filterChan) {
            System.out.printf(" Rquest filter1");
            filterChan.doFilter(requestP, responseP, filterChan);
            System.out.printf(" Response filter1");
            return true;
        }
    }

    class Filter2 implements Filter {

        public boolean doFilter(RequestP requestP, ResponseP responseP, FilterChan filterChan) {
            System.out.printf("Request filter2");
            //代码执行到这里并没有return，这里取找下一个节点
            filterChan.doFilter(requestP, responseP, filterChan);
            //return回来才执行这行代码
            System.out.printf(" Response filter2");
            return true;
        }
    }

    class FilterChan implements Filter {
        List<Filter> filters = new ArrayList<Filter>();
        int index = 0;

        public Filter add(Filter filter) {
            filters.add(filter);
            return this;
        }

        public boolean doFilter(RequestP requestP, ResponseP responseP, FilterChan filterChan) {
            if (index == filters.size()) {
                return false;
            }
            Filter filter = filters.get(index); //寻找下一个节点
            index++;
            return filter.doFilter(requestP, responseP, filterChan); //调用下一个节点
        }
    }
}
