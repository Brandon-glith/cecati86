package net.javaguides.springboot.ApplicationLayer;

public class GetNewAspirants implements InterfaceGetDifference {

    @Override
    public Integer getDifference(
            Integer numberPreviousStudents,
            Integer currentNumberApplicants) {
        
        if (numberPreviousStudents == 0 || numberPreviousStudents == null) {
            return 0;
        }
        return Math.abs(
            currentNumberApplicants - numberPreviousStudents);
    }

}
