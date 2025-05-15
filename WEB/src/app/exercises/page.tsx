import ExercisesItem from "@/components/exercises-item";
import Navbar from "@/components/navbar";
import { getExercises } from "@/app/actions/exercises-actions";
import { Button } from "@/components/ui/button";
import Link from "next/link";
import { Plus } from "lucide-react";
import { ExerciseState } from "@/type"; 

export default async function ExercisesPage() {
    const data: ExerciseState[] = await getExercises();

    return (
        <>
            <Navbar active="Treinos" />

            <main className="flex items-center justify-center h-max">
                <div className="bg-slate-900 rounded min-w-2/3 p-5 m-6">
                    <div className="flex justify-between items-center">
                        <h2 className="text-lg font-bold text-white">Treinos</h2>
                        <Button asChild>
                            <Link href="/exercises/form" className="flex items-center gap-2 bg-slate-800">
                                <Plus size={16} />
                                Novo Exercício
                            </Link>
                        </Button>
                    </div>

                    <div className="mt-4">
                        {data.length > 0 ? (
                            data.map((exercise) => (
                                <ExercisesItem key={exercise.id} exercise={exercise} />
                            ))
                        ) : (
                            <p className="text-white text-center mt-4">Nenhum exercício cadastrado.</p>
                        )}
                    </div>
                </div>
            </main>
        </>
    );
}
