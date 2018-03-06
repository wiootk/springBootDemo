package tk.wioo.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageableList<T> implements Serializable {
    private static final long serialVersionUID = 768859725396601724L;
    private int pageNo, totalPages, pageSize;
    private long totalRecords;
    private List<T> records = new ArrayList<T>();
    /**
     * @return 当前页码
     */
    public int getPageNo() {
        return pageNo;
    }
    /**
     * @param pageNo 当前页码
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
    /**
     * @return 总页数
     */
    public int getTotalPages() {
        return totalPages;
    }
    /**
     * @param totalPages 总页数
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
    /**
     * @return 当前页记录数
     */
    public int getPageSize() {
        return pageSize;
    }
    /**
     * @param pageSize 当前页记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    /**
     * @return 总记录数
     */
    public long getTotalRecords() {
        return totalRecords;
    }
    /**
     * @param totalRecords 总记录数
     */
    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }
    /**
     * @return 页面记录列表
     */
    public List<T> getRecords() {
        return records;
    }
    /**
     * @param records 页面记录列表
     */
    public void setRecords(List<T> records) {
        this.records = records;
    }
}
