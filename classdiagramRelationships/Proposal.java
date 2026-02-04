class Proposal {
    private String proposal_code;
    private String proposal_title;
    private StatusProposal proposal_status = StatusProposal.Waiting;

  
    public String getProposal_code() { return proposal_code; }
    public void setProposal_code(String code) { this.proposal_code = code; }

    public String getProposal_title() { return proposal_title; }
    public void setProposal_title(String title) { this.proposal_title = title; }

    public StatusProposal getProposal_status() { return proposal_status; }
    public void setProposal_status(StatusProposal status) { this.proposal_status = status; }
}