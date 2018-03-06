package com.tingyu.domain.basic;

public class TCodeType {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column basic.t_code_type.n_code_type
     *
     * @mbggenerated
     */
    private Integer nCodeType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column basic.t_code_type.c_code_name
     *
     * @mbggenerated
     */
    private String cCodeName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column basic.t_code_type.n_valid
     *
     * @mbggenerated
     */
    private Integer nValid;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic.t_code_type
     *
     * @mbggenerated
     */
    public TCodeType(Integer nCodeType, String cCodeName, Integer nValid) {
        this.nCodeType = nCodeType;
        this.cCodeName = cCodeName;
        this.nValid = nValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table basic.t_code_type
     *
     * @mbggenerated
     */
    public TCodeType() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column basic.t_code_type.n_code_type
     *
     * @return the value of basic.t_code_type.n_code_type
     *
     * @mbggenerated
     */
    public Integer getnCodeType() {
        return nCodeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column basic.t_code_type.n_code_type
     *
     * @param nCodeType the value for basic.t_code_type.n_code_type
     *
     * @mbggenerated
     */
    public void setnCodeType(Integer nCodeType) {
        this.nCodeType = nCodeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column basic.t_code_type.c_code_name
     *
     * @return the value of basic.t_code_type.c_code_name
     *
     * @mbggenerated
     */
    public String getcCodeName() {
        return cCodeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column basic.t_code_type.c_code_name
     *
     * @param cCodeName the value for basic.t_code_type.c_code_name
     *
     * @mbggenerated
     */
    public void setcCodeName(String cCodeName) {
        this.cCodeName = cCodeName == null ? null : cCodeName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column basic.t_code_type.n_valid
     *
     * @return the value of basic.t_code_type.n_valid
     *
     * @mbggenerated
     */
    public Integer getnValid() {
        return nValid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column basic.t_code_type.n_valid
     *
     * @param nValid the value for basic.t_code_type.n_valid
     *
     * @mbggenerated
     */
    public void setnValid(Integer nValid) {
        this.nValid = nValid;
    }
}