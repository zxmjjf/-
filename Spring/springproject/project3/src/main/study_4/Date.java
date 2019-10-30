package main.study_4;

public class Date {
    /*私有 域*/
    private int year; //年
    private int month; //月
    private int day; //日
    /******************************************************************************/


    /*构造器*/
    /**
     * <describe>默认构造器</describe>
     */
    public Date() {
        this(1997, 7, 16);
    }

    /**
     * <describe>含参构造器</describe>
     *
     * @param year  年数
     * @param month 月数
     * @param day   天数
     */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /*toString 方法*/
    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
    /*******************************************************************/

    /*setter 方法*/
    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }
    /********************************************************************/

    /*getter 方法*/
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}



