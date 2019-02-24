package com.Tonyt1272.techjobsoo2.models.forms;

import com.Tonyt1272.techjobsoo2.models.JobFieldType;

public class SearchForm {

    // The search options
    private JobFieldType[] fields = JobFieldType.values();

    // The selected search options
    private JobFieldType searchField = JobFieldType.ALL;

    // The search string
    private String keyword;

    public JobFieldType getSearchField() {
        return searchField;
    }

    public void setSearchField(JobFieldType searchField) {
        this.searchField = searchField;
    }

    public JobFieldType[] getFields() {
        return fields;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}

