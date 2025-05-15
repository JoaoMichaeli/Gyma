export type ExerciseState = {
    values: {
      name: string;
      muscleGroup: string;
      repetitions: number;
      series: number;
      restSec: number;
    };
    errors?: Record<string, string>;
  };
  