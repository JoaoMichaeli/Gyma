import CrudDropdown from "./crud-dropdown";

export type Exercise = {
    id?: number;
    name: string;
    muscleGroup: string | string[];
    repetitions: number;
    series: number;
    restSec: number;
};

interface ExercisesItemProps {
    exercise: Exercise;
}

export default function ExercisesItem({ exercise }: ExercisesItemProps) {
    return (
        <div className="flex justify-between items-center my-4 p-4 bg-slate-800 rounded-lg text-white">
            <div>
                <h3 className="text-lg font-bold">{exercise.name}</h3>
                <p className="text-sm text-gray-400">
                    <strong>Grupos Musculares:</strong> {Array.isArray(exercise.muscleGroup) 
                        ? exercise.muscleGroup.join(", ") 
                        : exercise.muscleGroup || "Não informado"}
                </p>
                <p className="text-sm">
                    <strong>{exercise.series} x {exercise.repetitions}</strong> repetições | <strong>{exercise.restSec}s</strong> de descanso
                </p>
            </div>

            <CrudDropdown />
        </div>
    );
}
